package com.catface.bkb.repository.entity.exd;

import com.catface.bkb.repository.entity.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/15
 */
@Data
public class RoleExd extends Role {

    @ApiModelProperty(value = "所属业务域名称")
    private String bizDomainName;
}
