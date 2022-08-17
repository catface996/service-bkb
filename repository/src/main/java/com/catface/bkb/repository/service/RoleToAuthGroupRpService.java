package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.repository.entity.RoleToAuthGroup;
import com.catface.bkb.repository.entity.exd.RoleToAuthGroupExd;
import com.catface.bkb.repository.param.QueryRoleToAuthGroupParam;

/**
 * <p>
 * 角色关联权限组 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-15
 */
public interface RoleToAuthGroupRpService extends IService<RoleToAuthGroup> {

    /**
     * 分页查询角色关联的权限组
     *
     * @param param 分页查询角色关联的权限组
     * @return 角色关联的权限组
     */
    Page<RoleToAuthGroupExd> queryOnePage(QueryRoleToAuthGroupParam param);
}
