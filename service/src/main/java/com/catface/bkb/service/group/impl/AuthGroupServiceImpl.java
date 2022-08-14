package com.catface.bkb.service.group.impl;

import com.catface.bkb.repository.service.AuthGroupRpService;
import com.catface.bkb.service.group.AuthGroupService;
import com.catface.bkb.service.group.param.SaveAuthGroupParam;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class AuthGroupServiceImpl implements AuthGroupService {

    private final AuthGroupRpService authGroupRpService;

    public AuthGroupServiceImpl(AuthGroupRpService authGroupRpService) {
        this.authGroupRpService = authGroupRpService;
    }

    /**
     * 保存权限组
     *
     * @param param 保存权限组的参数
     */
    @Override
    public void save(SaveAuthGroupParam param) {
        // 创建私有权限组时,检查同客户下的权限组的个数,当超过100个时,不允许继续创建

        //

    }
}
