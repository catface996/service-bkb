package com.catface.bkb.service.authority;

import com.catface.bkb.repository.entity.Authority;

/**
 * @author catface
 * @since 2022/8/14
 */
public interface AuthorityService {

    /**
     * 保存权限点
     * @param entity 待保存的权限点
     */
    void save(Authority entity);
}
