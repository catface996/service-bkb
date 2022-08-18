package com.catface.bkb.repository.entity.exd;

import com.catface.bkb.repository.entity.Authority;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class AuthorityExd extends Authority {

    @ApiModelProperty(value = "业务域名称")
    private String bizDomainName;

    @ApiModelProperty(value = "业务系统名称")
    private String bizServiceName;

    @ApiModelProperty(value = "所属权限组")
    private String authGroupName;
}
