package com.catface.bkb.service.role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.param.QueryRoleParam;

/**
 * @author catface
 * @since 2022/8/15
 */
public interface RoleService {

    /**
     * 保存角色
     *
     * @param entity 待保存的角色
     */
    void save(Role entity);

    /**
     * 分页查询角色
     *
     * @param param 客户ID,业务域ID,可见性,角色名称
     * @return 角色列表
     */
    Page<RoleExd> queryOnePage(QueryRoleParam param);

    /**
     * 删除私有角色
     *
     * @param id       私有角色ID
     * @param clientId 角色所属客户ID
     */
    void deletePrivate(Long id, Long clientId);
}
