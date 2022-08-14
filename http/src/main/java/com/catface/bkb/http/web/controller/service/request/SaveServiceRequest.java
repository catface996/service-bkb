package com.catface.bkb.http.web.controller.service.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "保存业务系统请求")
@Data
public class SaveServiceRequest {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "服务名",required = true,example = "伊甸园")
    @NotBlank(message = "服务名不能为空")
    private String serviceName;

    @ApiModelProperty(value = "服务编码,一般是服务的域名",required = true,example = "service-eden")
    @NotBlank(message = "服务编码不能为空")
    private String serviceCode;

    @ApiModelProperty(value = "获取权限数据的接入点")
    private String authEndpoint;

    @ApiModelProperty(value = "备注")
    private String remark;
}
