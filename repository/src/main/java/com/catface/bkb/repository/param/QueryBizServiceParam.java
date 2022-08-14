package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.BizService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class QueryBizServiceParam extends Page<BizService> {

    @ApiModelProperty(value = "业务系统名称")
    private String bizServiceName;

    @ApiModelProperty(value = "业务系统名称")
    private String bizServiceCode;
}
