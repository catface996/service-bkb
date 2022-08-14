package com.catface.bkb.http.web.controller.authority.request;

import com.catface.bkb.common.enums.AuthorityTypeEnum;
import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "分页查询权限点请求")
@Data
public class GetAuthorityRequest extends PageRequest {

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属业务系统ID")
    private Long bizServiceId;

    @ApiModelProperty(value = "权限点名称")
    private String authorityName;

    @ApiModelProperty(value = "权限点类型")
    private List<AuthorityTypeEnum> authorityTypes;

    @ApiModelProperty(value = "请求路径")
    private String url;


}
