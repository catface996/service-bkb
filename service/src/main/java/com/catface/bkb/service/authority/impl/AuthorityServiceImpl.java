package com.catface.bkb.service.authority.impl;

import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.service.AuthorityRpService;
import com.catface.bkb.repository.service.BizDomainRpService;
import com.catface.bkb.repository.service.BizServiceRpService;
import com.catface.bkb.service.authority.AuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    public AuthorityServiceImpl(AuthorityRpService authorityRpService, BizServiceRpService bizServiceRpService, BizDomainRpService bizDomainRpService) {
        this.authorityRpService = authorityRpService;
        this.bizServiceRpService = bizServiceRpService;
        this.bizDomainRpService = bizDomainRpService;
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
        Assert.notNull(bizService,"无效的业务系统");
        BizDomain bizDomain = bizDomainRpService.getById(entity.getBizDomainId());
        Assert.notNull(bizDomain,"无效的业务域");
        // 保存或者更新
        authorityRpService.saveOrUpdate(entity);
    }
}
