package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.entity.exd.UserToRoleExd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/18
 */
@Data
public class QueryUserToRoleParam extends Page<UserToRoleExd> {

    @ApiModelProperty(value = "客户ID",required = true)
    private Long clientId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "业务域ID")
    private Long bizDomainId;
}
