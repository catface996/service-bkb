package com.catface.bkb.http.web.controller.service.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "分页查询业务系统的请求")
@Data
public class GetBizServiceRequest extends PageRequest {

    @ApiModelProperty(value = "业务系统名称",example = "伊甸园")
    private String bizServiceName;

    @ApiModelProperty(value = "业务系统编码",example = "service-eden")
    private String bizServiceCode;
}
