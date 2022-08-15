package com.catface.bkb.http.web.controller.role.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/15
 */
@Data
@ApiModel(description = "删除角色请求")
public class DeleteRoleRequest {

    @ApiModelProperty(value = "会话中被操作的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "当前会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "待删除的角色ID", required = true, example = "123456")
    @NotNull(message = "待删除的角色ID不能为空")
    private Long roleId;
}
