package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.mapper.BizServiceMapper;
import com.catface.bkb.repository.param.QueryBizServiceParam;
import com.catface.bkb.repository.service.BizServiceRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 业务系统 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Slf4j
@Service
public class BizServiceRpServiceImpl extends ServiceImpl<BizServiceMapper, BizService> implements BizServiceRpService {

    /**
     * 分页查询业务系统
     *
     * @param param 业务系统编码,业务系统名称
     * @return 业务系统分页列表
     */
    @Override
    public Page<BizService> queryOnePage(QueryBizServiceParam param) {
        List<BizService> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }
}
