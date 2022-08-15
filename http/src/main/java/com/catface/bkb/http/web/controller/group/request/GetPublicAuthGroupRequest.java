package com.catface.bkb.http.web.controller.group.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/15
 */
@ApiModel(value = "获取公共的权限组请求")
@Data
public class GetPublicAuthGroupRequest {

    @ApiModelProperty(value = "父级权限组ID")
    private Long parentId = -1L;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;
}
