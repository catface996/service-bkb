package com.catface.bkb.repository.entity.exd;

import com.catface.bkb.repository.entity.RoleToAuthGroup;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/16
 */
@Data
public class RoleToAuthGroupExd extends RoleToAuthGroup {

    private String authGroupName;
}
