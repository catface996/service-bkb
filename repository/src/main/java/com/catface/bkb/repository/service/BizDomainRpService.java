package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.param.QueryBizDomainParam;

/**
 * <p>
 * 业务域 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface BizDomainRpService extends IService<BizDomain> {

    /**
     * 分页查询业务域
     *
     * @param param 业务域编码,业务域名称
     * @return 业务域分页列表
     */
    Page<BizDomain> queryOnePage(QueryBizDomainParam param);
}
