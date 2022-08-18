package com.catface.bkb.service.user2role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.exd.UserToRoleExd;
import com.catface.bkb.repository.param.QueryUserToRoleParam;

/**
 * @author catface
 * @since 2022/8/14
 */
public interface UserToRoleService {

    /**
     * 绑定角色到用户
     *
     * @param userId   待绑定的用户
     * @param roleId   待绑定到用户的角色
     * @param clientId 执行当前操作的用户所属客户
     * @param operator 操作人
     */
    void bind(Long userId, Long roleId, Long clientId, Long operator);

    /**
     * 解除用户已经绑定的角色
     *
     * @param userToRoleId 用户关联角色ID
     * @param clientId     执行当前操作的用户所属客户
     */
    void remove(Long userToRoleId, Long clientId);

    /**
     * 分页查询用户和角色的绑定关系
     *
     * @param param 客户,用户,角色,业务域以及分页信息
     * @return 用户和角色绑定列表
     */
    Page<UserToRoleExd> queryOnePage(QueryUserToRoleParam param);

}
