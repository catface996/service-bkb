package com.catface.bkb.http.web.controller.usr2role.reqeust;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/17
 */
@Data
@ApiModel(description = "获取用户和角色关联关系的请求")
public class GetUserToRoleRequest extends PageRequest {

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "待查看的用户ID", example = "121212")
    private Long userId;

    @ApiModelProperty(value = "待查看的角色ID", example = "21212121")
    private Long roleId;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;
}
