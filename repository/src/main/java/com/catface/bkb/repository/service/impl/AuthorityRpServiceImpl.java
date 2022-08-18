package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.exd.AuthorityExd;
import com.catface.bkb.repository.mapper.AuthorityMapper;
import com.catface.bkb.repository.param.QueryAuthorityParam;
import com.catface.bkb.repository.service.AuthorityRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限点 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Slf4j
@Service
public class AuthorityRpServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityRpService {

    /**
     * 分页查询权限点
     *
     * @param param 分页查询请求参数
     * @return 权限点列表
     */
    @Override
    public Page<AuthorityExd> queryOnePage(QueryAuthorityParam param) {
        List<AuthorityExd> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }

    /**
     * 根据业务域和url查询权限点
     *
     * @param bizDomainId 业务域ID
     * @param url         url
     * @return 权限点
     */
    @Override
    public Authority queryByBizDomainUrl(Long bizDomainId, String url) {
        return baseMapper.selectByBizDomainUrl(bizDomainId, url);
    }
}
