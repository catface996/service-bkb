package com.catface.bkb.http.web.controller.role.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/15
 */
@Data
@ApiModel(description = "分页查询私有角色请求")
public class GetPrivateRoleRequest extends PageRequest {

    @ApiModelProperty(value = "会话中被操作的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "所属业务域")
    private Long bizDomainId;

}
