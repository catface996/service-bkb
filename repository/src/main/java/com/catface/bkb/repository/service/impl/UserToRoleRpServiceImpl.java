package com.catface.bkb.repository.service.impl;

import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.mapper.UserToRoleMapper;
import com.catface.bkb.repository.service.UserToRoleRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户关联角色 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Service
public class UserToRoleRpServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements UserToRoleRpService {

}
