package com.catface.bkb.http.web.controller.service.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "业务系统模型")
@Data
public class BizServiceResponse {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "服务名")
    private String bizServiceName;

    @ApiModelProperty(value = "服务编码,一般是服务的域名")
    private String bizServiceCode;

    @ApiModelProperty(value = "获取权限数据的接入点")
    private String authEndpoint;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;
}
