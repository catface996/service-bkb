package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.param.QueryRoleParam;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface RoleRpService extends IService<Role> {

    /**
     * 分页查询角色列表
     *
     * @param param 客户ID,业务域ID,可见性,角色名称
     * @return 角色列表
     */
    Page<RoleExd> queryOnePage(QueryRoleParam param);
}
