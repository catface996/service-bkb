package com.catface.bkb.service.role.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.RoleToAuthGroup;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.entity.exd.RoleToAuthGroupExd;
import com.catface.bkb.repository.param.QueryRoleParam;
import com.catface.bkb.repository.param.QueryRoleToAuthGroupParam;
import com.catface.bkb.repository.service.AuthGroupRpService;
import com.catface.bkb.repository.service.BizDomainRpService;
import com.catface.bkb.repository.service.RoleRpService;
import com.catface.bkb.repository.service.RoleToAuthGroupRpService;
import com.catface.bkb.service.role.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/15
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRpService roleRpService;

    private final BizDomainRpService bizDomainRpService;

    private final AuthGroupRpService authGroupRpService;

    private final RoleToAuthGroupRpService roleToAuthGroupRpService;

    public RoleServiceImpl(RoleRpService roleRpService, BizDomainRpService bizDomainRpService,
                           AuthGroupRpService authGroupRpService, RoleToAuthGroupRpService roleToAuthGroupRpService) {
        this.roleRpService = roleRpService;
        this.bizDomainRpService = bizDomainRpService;
        this.authGroupRpService = authGroupRpService;
        this.roleToAuthGroupRpService = roleToAuthGroupRpService;
    }

    /**
     * 保存角色
     *
     * @param entity 待保存的角色
     */
    public void save(Role entity) {

        // 首先检查BizDomain是否有效
        BizDomain domain = bizDomainRpService.getById(entity.getBizDomainId());
        Assert.notNull(domain, "无效的业务域");

        // 如果是更新,检查clientId是否发生变化
        if (entity.getId() != null) {
            Role roleOld = roleRpService.getById(entity.getId());
            Assert.state(entity.getClientId().equals(roleOld.getClientId()), "禁止更改其他客户的角色");
        }

        // 客户创建的角色的可见性均为PRIVATE
        if (entity.getClientId() != null && !entity.getClientId().equals(-1L)) {
            entity.setVisibility(VisibilityEnum.PRIVATE);
        }

        // 执行更新
        roleRpService.saveOrUpdate(entity);
    }

    /**
     * 分页查询角色
     *
     * @param param 客户ID,业务域ID,可见性,角色名称
     * @return 角色列表
     */
    @Override
    public Page<RoleExd> queryOnePage(QueryRoleParam param) {
        return roleRpService.queryOnePage(param);
    }

    /**
     * 删除私有角色
     *
     * @param id       私有角色ID
     * @param clientId 角色所属客户ID
     */
    @Override
    public void deletePrivate(Long id, Long clientId) {

        // 检查角色是否存在
        Role role = roleRpService.getById(id);
        if (role == null) {
            log.warn("待删除的角色不存在,角色ID:{}", id);
            return;
        }
        // 首先检查角色是否是PRIVATE
        Assert.state(role.getVisibility() == VisibilityEnum.PRIVATE, "仅允许删除私有角色");

        // 检查角色是否属于当前操作的客户
        Assert.state(role.getClientId().equals(clientId), "禁止删除其他客户的角色");

        roleRpService.removeById(id);

    }

    /**
     * 绑定权限组到角色上
     *
     * @param roleId      角色ID
     * @param authGroupId 权限组ID
     * @param clientId    客户ID
     * @param operator    操作人
     */
    @Override
    public void bindAuthGroup(Long roleId, Long authGroupId, Long clientId, Long operator) {

        // 检查角色和权限是否存,并检查是否是私有自建
        Role role = roleRpService.getById(roleId);
        Assert.notNull(role, "待绑定权限组的角色不存在");
        Assert.state(role.getVisibility() == VisibilityEnum.PRIVATE, "仅支持对私有角色做权限组绑定");
        Assert.state(role.getClientId().equals(clientId), "仅支持对自有角色做权限组绑定");

        // 此处注意,允许将公共权限组绑定到自建的私有角色上
        // 如果是私有的权限组,需要检查权限组所属客户是否与当前指定的客户一致
        AuthGroup authGroup = authGroupRpService.getById(authGroupId);
        Assert.notNull(authGroup, "待绑定到角色的权限组不存在");

        if (authGroup.getVisibility().equals(VisibilityEnum.PRIVATE)) {
            Assert.state(authGroup.getClientId().equals(clientId), "不支持绑定非自建的私有权限组");
        }

        // 构建并保存角色和权限组的关联关系
        buildAndSaveRoleToAuthGroup(roleId, authGroupId, operator);

    }

    /**
     * 查询角色关联的权限组
     *
     * @param param    分页参数,包括角色ID和角色名称
     * @param clientId 客户ID
     * @return 角色绑定的权限组
     */
    @Override
    public Page<RoleToAuthGroupExd> queryAuthGroup(QueryRoleToAuthGroupParam param, Long clientId) {

        // 检查角色是否是私有自建角色
        Role role = roleRpService.getById(param.getRoleId());
        Assert.notNull(role, "角色不能为空");
        if (role.getVisibility() == VisibilityEnum.PRIVATE) {
            Assert.state(role.getClientId().equals(clientId),"非自建私有角色");
        }
        // 查询分页结果,并返回
        return roleToAuthGroupRpService.queryOnePage(param);
    }

    /**
     * 构建并保存角色和权限组的绑定关系
     *
     * @param roleId      角色ID
     * @param authGroupId 权限组ID
     * @param operator    操作人
     */
    private void buildAndSaveRoleToAuthGroup(Long roleId, Long authGroupId, Long operator) {
        RoleToAuthGroup entity = new RoleToAuthGroup();
        entity.setRoleId(roleId);
        entity.setAuthGroupId(authGroupId);
        entity.setCreator(operator);
        roleToAuthGroupRpService.save(entity);
    }


}
