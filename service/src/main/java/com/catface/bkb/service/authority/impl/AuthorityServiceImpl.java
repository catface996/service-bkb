package com.catface.bkb.service.authority.impl;

import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.service.*;
import com.catface.bkb.service.authority.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author catface
 * @since 2022/8/14
 */
@Slf4j
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRpService authorityRpService;

    private final BizServiceRpService bizServiceRpService;

    private final BizDomainRpService bizDomainRpService;

    private final UserToRoleRpService userToRoleRpService;

    private final RoleToAuthGroupRpService roleToAuthGroupRpService;


    public AuthorityServiceImpl(AuthorityRpService authorityRpService, BizServiceRpService bizServiceRpService,
                                BizDomainRpService bizDomainRpService, UserToRoleRpService userToRoleRpService,
                                RoleToAuthGroupRpService roleToAuthGroupRpService) {
        this.authorityRpService = authorityRpService;
        this.bizServiceRpService = bizServiceRpService;
        this.bizDomainRpService = bizDomainRpService;
        this.userToRoleRpService = userToRoleRpService;
        this.roleToAuthGroupRpService = roleToAuthGroupRpService;
    }

    /**
     * 保存权限点
     *
     * @param entity 待保存的权限点
     */
    @Override
    public void save(Authority entity) {
        // 业务参数有效性校验
        BizService bizService = bizServiceRpService.getById(entity.getBizServiceId());
        Assert.notNull(bizService, "无效的业务系统");
        BizDomain bizDomain = bizDomainRpService.getById(entity.getBizDomainId());
        Assert.notNull(bizDomain, "无效的业务域");
        // 保存或者更新
        authorityRpService.saveOrUpdate(entity);
    }

    /**
     * 检查用户在指定客户下是否有相应的访问权限
     *
     * @param clientId      客户ID
     * @param userId        用户ID
     * @param bizDomainCode 业务域
     * @param url           url
     */
    @Override
    public boolean checkAuthority(Long clientId, Long userId, String bizDomainCode, String url) {

        //TODO 首先在缓存中查找,直接返回缓存中的结果

        // 检查用户和客户是否有关联关系
        List<UserToRole> userToRoles = userToRoleRpService.queryByClientUser(clientId, userId);
        if (CollectionUtils.isEmpty(userToRoles)) {
            log.warn("客户:{},未授予任何权限给用户:{}", clientId, userId);
            return false;
        }

        // 根据业务域编码查询对应的业务域,并检查是否有效
        BizDomain bizDomain = bizDomainRpService.queryByCode(bizDomainCode);
        if (bizDomain == null) {
            log.warn("无效的业务域,业务域编码:{}", bizDomainCode);
            return false;
        }

        // 检查待访问的权限点是否存在
        Authority authority = authorityRpService.queryByBizDomainUrl(bizDomain.getId(), url);
        if (authority == null) {
            log.warn("无效的权限点,业务域编码:{},url:{}", bizDomainCode, url);
            return false;
        }

        // 检查角色是否绑定了权限点所属的权限组
        Set<Long> roleIds = userToRoles.stream().map(UserToRole::getRoleId).collect(Collectors.toSet());
        boolean result =  roleToAuthGroupRpService.hasAuthGroup(roleIds, authority.getAuthGroupId());

        // TODO 加入缓存

        return result;
    }
}
