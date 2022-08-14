package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.param.QueryBizDomainParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 业务域 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface BizDomainMapper extends BaseMapper<BizDomain> {

    /**
     * 分页查询业务域
     *
     * @param param 业务域编码,业务域名称
     * @return 分页列表
     */
    List<BizDomain> selectOnePage(@Param("param") QueryBizDomainParam param);
}
