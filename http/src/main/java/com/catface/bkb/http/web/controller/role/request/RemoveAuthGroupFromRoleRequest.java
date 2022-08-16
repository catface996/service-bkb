package com.catface.bkb.http.web.controller.role.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/16
 */
@ApiModel(description = "删除角色和权限组关联关系请求")
@Data
public class RemoveAuthGroupFromRoleRequest {

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "待删除的角色和权限组的关联关系ID", required = true, example = "121212121212")
    @NotNull(message = "待删除的角色和权限组的关联关系ID不能为空")
    private Long roleToAuthGroupId;
}
