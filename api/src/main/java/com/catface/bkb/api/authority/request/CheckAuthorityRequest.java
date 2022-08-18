package com.catface.bkb.api.authority.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/18
 */
@Data
@ApiModel(description = "检查用户在指定的客户下是否访问权限请求")
public class CheckAuthorityRequest {

    @ApiModelProperty(value = "业务域编码", required = true, example = "saas-api.catface.com")
    @NotBlank(message = "业务域编码不能为空")
    private String bizDomainCode;

    @ApiModelProperty(value = "请求路径", required = true, example = "/wms/public/warehouse/detail")
    @NotBlank(message = "请求路径不能为空")
    private String url;

    @ApiModelProperty(value = "客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long clientId;

    @ApiModelProperty(value = "用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

}
