package com.catface.bkb.http.web.controller.group.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class GetPrivateAuthGroupRequest {

    @ApiModelProperty(value = "父级权限组ID")
    private Long parentId = -1L;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "当前登录的用户所操作的客户ID", required = true, example = "987654321")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;
}
