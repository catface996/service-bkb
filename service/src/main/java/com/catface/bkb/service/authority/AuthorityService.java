package com.catface.bkb.service.authority;

import com.catface.bkb.repository.entity.Authority;

/**
 * @author catface
 * @since 2022/8/14
 */
public interface AuthorityService {

    /**
     * 保存权限点
     *
     * @param entity 待保存的权限点
     */
    void save(Authority entity);

    /**
     * 检查用户在指定客户下是否有相应的访问权限
     *
     * @param clientId      客户ID
     * @param userId        用户ID
     * @param bizDomainCode 业务域
     * @param url           url
     * @return true:允许访问;false:不允许访问
     */
    boolean checkAuthority(Long clientId, Long userId, String bizDomainCode, String url);
}
