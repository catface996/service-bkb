package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.common.enums.AuthorityTypeEnum;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.exd.AuthorityExd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class QueryAuthorityParam extends Page<AuthorityExd> {

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

    @ApiModelProperty(value = "可见性")
    private VisibilityEnum visibility;
}
