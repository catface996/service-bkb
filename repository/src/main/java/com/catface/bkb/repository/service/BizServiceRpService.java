package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.param.QueryBizServiceParam;

/**
 * <p>
 * 业务系统 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface BizServiceRpService extends IService<BizService> {


    /**
     * 分页查询业务系统
     *
     * @param param 业务系统编码,业务系统名称
     * @return 业务系统分页列表
     */
    Page<BizService> queryOnePage(QueryBizServiceParam param);
}
