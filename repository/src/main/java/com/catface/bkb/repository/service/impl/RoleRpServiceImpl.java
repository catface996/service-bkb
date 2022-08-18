package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.mapper.RoleMapper;
import com.catface.bkb.repository.param.QueryRoleParam;
import com.catface.bkb.repository.service.RoleRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Slf4j
@Service
public class RoleRpServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleRpService {

    /**
     * 分页查询角色列表
     *
     * @param param 客户ID,业务域ID,可见性,角色名称
     * @return 角色列表
     */
    @Override
    public Page<RoleExd> queryOnePage(QueryRoleParam param) {
        List<RoleExd> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }

    /**
     * 判断角色列表中是否包含权限点
     *
     * @param roleIds     角色ID列表
     * @param authorityId 权限点ID
     * @return true:包含;false:不包含;
     */
    @Override
    public boolean hasAuthority(Set<Long> roleIds, Long authorityId) {
        return false;
    }
}
