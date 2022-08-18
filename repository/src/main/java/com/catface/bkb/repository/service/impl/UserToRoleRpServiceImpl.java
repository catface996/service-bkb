package com.catface.bkb.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.entity.exd.UserToRoleExd;
import com.catface.bkb.repository.mapper.UserToRoleMapper;
import com.catface.bkb.repository.param.QueryUserToRoleParam;
import com.catface.bkb.repository.service.UserToRoleRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户关联角色 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Slf4j
@Service
public class UserToRoleRpServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements UserToRoleRpService {

    /**
     * 分页查询用户和角色的关联关系
     *
     * @param param 客户,用户,角色,业务域,分页信息
     * @return 用户关联的客户
     */
    @Override
    public Page<UserToRoleExd> queryOnePage(QueryUserToRoleParam param) {
        List<UserToRoleExd> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }
}
