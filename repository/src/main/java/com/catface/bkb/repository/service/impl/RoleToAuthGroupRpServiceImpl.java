package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.repository.entity.RoleToAuthGroup;
import com.catface.bkb.repository.entity.exd.RoleToAuthGroupExd;
import com.catface.bkb.repository.mapper.RoleToAuthGroupMapper;
import com.catface.bkb.repository.param.QueryRoleToAuthGroupParam;
import com.catface.bkb.repository.service.RoleToAuthGroupRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色关联权限组 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-15
 */
@Slf4j
@Service
public class RoleToAuthGroupRpServiceImpl extends ServiceImpl<RoleToAuthGroupMapper, RoleToAuthGroup> implements RoleToAuthGroupRpService {


    /**
     * 分页查询角色关联的权限组
     *
     * @param param 分页查询角色关联的权限组
     * @return 角色关联的权限组
     */
    @Override
    public Page<RoleToAuthGroupExd> queryOnePage(QueryRoleToAuthGroupParam param) {
        List<RoleToAuthGroupExd> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }

    /**
     * 检查角色中是否包含指定的权限点
     *
     * @param roleIds     角色ID列表
     * @param authGroupId 权限组ID
     * @return true:包含;false:不包含;
     */
    @Override
    public boolean hasAuthGroup(Set<Long> roleIds, Long authGroupId) {
        List<RoleToAuthGroup> list = baseMapper.selectByRoleIdsGroupId(roleIds, authGroupId);
        return !CollectionUtils.isEmpty(list);
    }
}
