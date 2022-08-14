package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.Authority;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.repository.entity.exd.AuthorityExd;
import com.catface.bkb.repository.param.QueryAuthorityParam;

/**
 * <p>
 * 权限点 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface AuthorityRpService extends IService<Authority> {


    /**
     * 分页查询权限点
     * @param param 分页查询请求参数
     * @return 权限点列表
     */
    Page<AuthorityExd> queryOnePage(QueryAuthorityParam param);
}
