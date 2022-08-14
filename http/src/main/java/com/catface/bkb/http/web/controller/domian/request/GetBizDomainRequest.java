package com.catface.bkb.http.web.controller.domian.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "分页查询业务域请求")
@Data
public class GetBizDomainRequest extends PageRequest {

    @ApiModelProperty(value = "业务域名称",required = true,example = "saas系统")
    private String bizDomainName;

    @ApiModelProperty(value = "业务域编码",required = true,example = "saas")
    private String bizDomainCode;

}
