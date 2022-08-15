package com.catface.bkb.service.role.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.param.QueryRoleParam;
import com.catface.bkb.repository.service.BizDomainRpService;
import com.catface.bkb.repository.service.RoleRpService;
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

    public RoleServiceImpl(RoleRpService roleRpService, BizDomainRpService bizDomainRpService) {
        this.roleRpService = roleRpService;
        this.bizDomainRpService = bizDomainRpService;
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


}
