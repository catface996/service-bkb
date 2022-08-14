package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.param.QueryBizServiceParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 业务系统 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface BizServiceMapper extends BaseMapper<BizService> {

    /**
     * 分页查询业务系统
     *
     * @param param 业务系统名称或者编码
     * @return 业务系统列表
     */
    List<BizService> selectOnePage(@Param("param") QueryBizServiceParam param);
}
