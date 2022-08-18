package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.entity.exd.UserToRoleExd;
import com.catface.bkb.repository.param.QueryUserToRoleParam;

/**
 * <p>
 * 用户关联角色 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface UserToRoleRpService extends IService<UserToRole> {

    /**
     * 分页查询用户和角色的关联关系
     *
     * @param param 客户,用户,角色,业务域,分页信息
     * @return 用户关联的客户
     */
    Page<UserToRoleExd> queryOnePage(QueryUserToRoleParam param);
}
