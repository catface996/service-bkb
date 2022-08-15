package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.repository.mapper.AuthGroupMapper;
import com.catface.bkb.repository.service.AuthGroupRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限组 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Slf4j
@Service
public class AuthGroupRpServiceImpl extends ServiceImpl<AuthGroupMapper, AuthGroup> implements AuthGroupRpService {

    /**
     * 根据上一级的ID查询下一级的权限组
     *
     * @param visibility  可见性
     * @param bizDomainId 所属业务域
     * @param clientId    所属客户ID
     * @param parentId    上一级的权限组ID
     * @return 下一级的权限组列表
     */
    @Override
    public List<AuthGroup> queryChildren(VisibilityEnum visibility, Long bizDomainId, Long clientId, Long parentId) {
        return baseMapper.selectChildren(visibility, bizDomainId, clientId, parentId);
    }

    /**
     * 根据客户ID统计权限组的个数
     *
     * @param clientId 所属客户ID
     * @return 客户创建的权限组的个数
     */
    @Override
    public Integer countByClient(Long clientId) {
        return baseMapper.countByClientId(clientId);
    }
}
