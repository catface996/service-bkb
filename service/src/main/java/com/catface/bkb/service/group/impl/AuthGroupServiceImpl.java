package com.catface.bkb.service.group.impl;

import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.service.AuthGroupRpService;
import com.catface.bkb.repository.service.BizDomainRpService;
import com.catface.bkb.service.group.AuthGroupService;
import com.catface.bkb.service.group.convert.AuthGroupServiceConvert;
import com.catface.bkb.service.group.param.SaveAuthGroupParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/14
 */
@Slf4j
@Service
public class AuthGroupServiceImpl implements AuthGroupService {

    private final AuthGroupRpService authGroupRpService;

    private final BizDomainRpService bizDomainRpService;

    public AuthGroupServiceImpl(AuthGroupRpService authGroupRpService, BizDomainRpService bizDomainRpService) {
        this.authGroupRpService = authGroupRpService;
        this.bizDomainRpService = bizDomainRpService;
    }

    /**
     * 保存权限组
     *
     * @param param 保存权限组的参数
     */
    @Override
    public void save(SaveAuthGroupParam param) {

        // 检查所属业务域是否存在
        BizDomain domain = bizDomainRpService.getById(param.getBizDomainId());
        Assert.notNull(domain, "无效的业务域选项");

        // 检查parent是否存在
        if (param.getParentId() != null && !param.getParentId().equals(-1L)) {
            AuthGroup parent = authGroupRpService.getById(param.getParentId());
            Assert.notNull(parent, "无效的父级权限组");
            Assert.state(param.getBizDomainId().equals(parent.getBizDomainId()), "与父级权限组所属业务域不一致");
        }

        // 创建私有权限组时,检查同客户下的权限组的个数,当超过100个时,不允许继续创建
        Integer count = authGroupRpService.countByClient(param.getClientId());
        Assert.state(count <= 100, "权限组最多允许创建100个");

        // 构造并保存权限组
        AuthGroup entity = AuthGroupServiceConvert.convert(param);
        if (entity.getClientId() != null && !entity.getClientId().equals(-1L)) {
            entity.setVisibility(VisibilityEnum.PRIVATE);
        }
        authGroupRpService.saveOrUpdate(entity);

    }

    /**
     * 根据上一级的ID查询下一级的权限组
     *
     * @param visibility  可见性
     * @param bizDomainId 所属业务域
     * @param clientId    所属客户ID
     * @param parentId    上一级的权限组ID
     * @return 下一级的权限组列表
     */
    @Override
    public List<AuthGroup> queryChildren(VisibilityEnum visibility, Long bizDomainId, Long clientId, Long parentId) {
        return authGroupRpService.queryChildren(visibility, bizDomainId, clientId, parentId);
    }

    /**
     * 删除权限组,仅当所属客户一致,且为PRIVATE的权限组
     *
     * @param id       权限组ID
     * @param clientId 所属客户ID
     */
    @Override
    public void delete(Long id, Long clientId) {
        AuthGroup authGroup = authGroupRpService.getById(id);
        if (authGroup == null) {
            log.warn("待删除的权限组不存在,待删除权限组ID:{}", id);
            return;
        }
        Assert.state(authGroup.getClientId().equals(clientId),"不允许删除非当前客户的权限组");
        Assert.state(authGroup.getVisibility()==VisibilityEnum.PRIVATE,"仅允许删除私有权限组");
        authGroupRpService.removeById(id);
    }
}
