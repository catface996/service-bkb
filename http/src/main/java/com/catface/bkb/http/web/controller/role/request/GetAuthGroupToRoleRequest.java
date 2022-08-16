package com.catface.bkb.http.web.controller.role.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/16
 */
@Data
@ApiModel(description = "获取角色绑定的权限组请求")
public class GetAuthGroupToRoleRequest extends PageRequest {

    @ApiModelProperty(value = "会话中的客户ID",required = true,example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID",required = true,example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "角色ID,仅支持查看公共角色和自建的私有角色",required = true,example = "1234321")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    @ApiModelProperty(value = "权限组名称",example = "库区管理")
    private String authGroupNae;
}
