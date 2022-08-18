package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.mapper.BizDomainMapper;
import com.catface.bkb.repository.param.QueryBizDomainParam;
import com.catface.bkb.repository.service.BizDomainRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 业务域 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Slf4j
@Service
public class BizDomainRpServiceImpl extends ServiceImpl<BizDomainMapper, BizDomain> implements BizDomainRpService {

    /**
     * 分页查询业务域
     *
     * @param param 业务域编码,业务域名称
     * @return 业务域分页列表
     */
    @Override
    public Page<BizDomain> queryOnePage(QueryBizDomainParam param) {
        List<BizDomain> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }

    /**
     * 根据业务域编码查询业务域
     *
     * @param bizDomainCode 业务域编码
     * @return 业务域
     */
    @Override
    public BizDomain queryByCode(String bizDomainCode) {
        return baseMapper.selectByBizDomainCode(bizDomainCode);
    }
}
