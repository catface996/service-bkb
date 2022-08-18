package com.catface.bkb.http.web.controller.usr2role.reqeust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/17
 */
@Data
@ApiModel(description = "移除用户绑定的角色请求")
public class RemoveRoleFromUserRequest {

    @ApiModelProperty(value = "会话中的用户ID",required = true,example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "会话中的客户ID",required = true,example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "用户关联角色ID",required = true,example = "12121212")
    @NotNull(message = "用户关联角色ID不能为空")
    private Long userToRoleId;

}
