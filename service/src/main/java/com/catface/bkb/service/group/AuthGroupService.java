package com.catface.bkb.service.group;

import com.catface.bkb.service.group.param.SaveAuthGroupParam;

/**
 * @author catface
 * @since 2022/8/14
 */
public interface AuthGroupService {

    /**
     * 保存权限组
     * @param param 保存权限组的参数
     */
    void save(SaveAuthGroupParam param);
}
