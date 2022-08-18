package com.catface.bkb.http.web.controller.usr2role.reqeust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/17
 */
@ApiModel(description = "绑定角色到用户请求")
@Data
public class BindRoleToUserRequest {

    @ApiModelProperty(value = "会话中的客户ID",required = true,example = "1234567890")
    @NotNull(message ="会话中的")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID",required = true,example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "待绑定的用户ID",required = true,example = "11221122")
    @NotNull(message = "待绑定的用户ID不能为空")
    private Long bindUserId;

    @ApiModelProperty(value = "待绑定的角色ID",required = true,example = "11221122")
    @NotNull(message = "待绑定的用户ID不能为空")
    private Long bindRoleId;
}
