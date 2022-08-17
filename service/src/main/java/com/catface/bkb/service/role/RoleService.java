package com.catface.bkb.service.role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.entity.exd.RoleToAuthGroupExd;
import com.catface.bkb.repository.param.QueryRoleParam;
import com.catface.bkb.repository.param.QueryRoleToAuthGroupParam;

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

    /**
     * 绑定权限组到角色上
     *
     * @param roleId      角色ID
     * @param authGroupId 权限组ID
     * @param clientId    客户ID
     * @param operator    操作人
     */
    void bindAuthGroup(Long roleId, Long authGroupId, Long clientId, Long operator);

    /**
     * 查询角色关联的权限组
     *
     * @param param    分页参数,包括角色ID和角色名称
     * @param clientId 客户ID
     * @return 角色绑定的权限组
     */
    Page<RoleToAuthGroupExd> queryAuthGroup(QueryRoleToAuthGroupParam param, Long clientId);
}
