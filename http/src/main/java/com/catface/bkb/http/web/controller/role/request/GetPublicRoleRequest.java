package com.catface.bkb.http.web.controller.role.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/15
 */
@ApiModel(description = "查询公共角色请求")
@Data
public class GetPublicRoleRequest extends PageRequest {

    @ApiModelProperty(value = "角色名称",required = true,example = "仓库管理员")
    private String roleName;

    @ApiModelProperty(value = "业务域ID",required = true,example = "123456")
    private Long bizDomainId;

}
