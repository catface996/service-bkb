package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.BizService;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class QueryBizServiceParam extends Page<BizService> {

    private String serviceName;

    private String serviceCode;
}
