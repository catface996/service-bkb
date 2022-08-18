package com.catface.bkb.http.web.controller.authority.response;

import com.catface.bkb.common.enums.AuthorityTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "权限点模型")
@Data
public class AuthorityResponse {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "权限点名称")
    private String authorityName;

    @ApiModelProperty(value = "权限点类型： 查询类和操作类;")
    private AuthorityTypeEnum authorityType;

    @ApiModelProperty(value = "所属业务系统")
    private String serviceName;

    @ApiModelProperty(value = "权限点URL")
    private String url;

    @ApiModelProperty(value = "所属业务域编码")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属业务域名称")
    private String bizDomainName;

    @ApiModelProperty(value = "权限组ID")
    private Long authGroupId;

    @ApiModelProperty(value = "权限组名称")
    private String authGroupName;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;

}
