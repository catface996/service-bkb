package com.catface.bkb.http.web.controller.group.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "删除权限组请求")
@Data
public class DeleteAuthGroupRequest {

    @ApiModelProperty(value = "待删除权限组ID",required = true,example = "12121212")
    @NotNull(message = "待删除权限组id不能为空")
    private Long id;

    @ApiModelProperty(value = "当前登录的用户ID",required = true,example = "1234567890")
    @NotNull(message = "当前登录的用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "被操作的当前客户ID",required = true,example = "9876543210")
    @NotNull(message = "被操作的当前客户ID不能为空")
    private Long ctxClientId;
}
