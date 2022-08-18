package com.catface.bkb.repository.entity.exd;

import com.catface.bkb.repository.entity.UserToRole;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/18
 */
@Data
public class UserToRoleExd extends UserToRole {

    private String roleName;

    private String bizDomainName;
}
