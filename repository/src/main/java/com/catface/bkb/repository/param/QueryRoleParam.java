package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.exd.RoleExd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/15
 */
@Data
public class QueryRoleParam extends Page<RoleExd> {

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "可见性")
    private VisibilityEnum visibility;

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
