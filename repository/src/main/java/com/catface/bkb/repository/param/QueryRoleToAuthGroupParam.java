package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.RoleToAuthGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/16
 */
@Data
@ApiModel(description = "查询角色关联的权限组参数")
public class QueryRoleToAuthGroupParam extends Page<RoleToAuthGroup> {

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限组名称")
    private String authGroupName;
}
