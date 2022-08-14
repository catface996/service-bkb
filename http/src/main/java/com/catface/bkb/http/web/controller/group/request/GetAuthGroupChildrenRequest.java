package com.catface.bkb.http.web.controller.group.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
}
