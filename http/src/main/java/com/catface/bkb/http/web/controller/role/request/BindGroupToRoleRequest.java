package com.catface.bkb.http.web.controller.role.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/16
 */
@Data
@ApiModel(description = "绑定权限组到角色请求")
public class BindGroupToRoleRequest {

    @ApiModelProperty(value = "当前会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID")
    private Long ctxUserId;

    @ApiModelProperty(value = "当前会话中的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID")
    private Long ctxClientId;

    @ApiModelProperty(value = "权限组ID,公共权限组或者属于客户自建的权限组", required = true, example = "123456")
    @NotNull(message = "权限组ID不能为空")
    private Long authGroupId;

    @ApiModelProperty(value = "角色ID,仅限客户自建角色", required = true, example = "9876543")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;
}
