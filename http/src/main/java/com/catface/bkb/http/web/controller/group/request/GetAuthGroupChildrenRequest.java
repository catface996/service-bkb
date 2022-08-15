package com.catface.bkb.http.web.controller.group.request;

import com.catface.bkb.common.enums.VisibilityEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class GetAuthGroupChildrenRequest {

    @ApiModelProperty(value = "parentId")
    private Long parentId = -1L;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "当前登录的用户所操作的客户ID", required = true, example = "987654321")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "可见性", required = true, example = "PUBLIC")
    @NotNull(message = "可见性不能为空")
    private VisibilityEnum visibility;
}
