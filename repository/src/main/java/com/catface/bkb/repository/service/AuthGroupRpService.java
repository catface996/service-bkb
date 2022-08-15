package com.catface.bkb.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.AuthGroup;

import java.util.List;

/**
 * <p>
 * 权限组 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface AuthGroupRpService extends IService<AuthGroup> {

    /**
     * 根据上一级的ID查询下一级的权限组
     *
     * @param visibility  可见性
     * @param bizDomainId 所属业务域
     * @param clientId    所属客户ID
     * @param parentId    上一级的权限组ID
     * @return 下一级的权限组列表
     */
    List<AuthGroup> queryChildren(VisibilityEnum visibility, Long bizDomainId, Long clientId, Long parentId);

    /**
     * 根据客户ID统计权限组的个数
     *
     * @param clientId 所属客户ID
     * @return 客户创建的权限组的个数
     */
    Integer countByClient(Long clientId);
}
