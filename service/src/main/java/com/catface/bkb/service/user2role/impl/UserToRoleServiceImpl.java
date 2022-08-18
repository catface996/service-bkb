package com.catface.bkb.service.user2role.impl;

import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.service.RoleRpService;
import com.catface.bkb.repository.service.UserToRoleRpService;
import com.catface.bkb.service.user2role.UserToRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/18
 */
@Slf4j
@Service
public class UserToRoleServiceImpl implements UserToRoleService {

    private final UserToRoleRpService userToRoleRpService;

    private final RoleRpService roleRpService;

    public UserToRoleServiceImpl(UserToRoleRpService userToRoleRpService, RoleRpService roleRpService) {
        this.userToRoleRpService = userToRoleRpService;
        this.roleRpService = roleRpService;
    }

    /**
     * 绑定角色到用户
     *
     * @param userId   待绑定的用户
     * @param roleId   待绑定到用户的角色
     * @param clientId 执行当前操作的用户所属客户
     * @param operator 操作人
     */
    public void bind(Long userId, Long roleId, Long clientId, Long operator) {

        // 检查待绑定角色是否存在
        Role role = roleRpService.getById(roleId);
        Assert.notNull(role, "待绑定的角色不存在");
        // 判断待绑定角色是否是公共角色,如果不是,需要判断角色是否归属于当前客户
        if (role.getVisibility() == VisibilityEnum.PRIVATE) {
            Assert.state(role.getClientId().equals(clientId), "仅支持对自建私有角色的绑定");
        }
        // 构建并保存绑定关系
        buildAndSaveUserToRole(userId, role, clientId, operator);

    }

    /**
     * 解除用户已经绑定的角色
     *
     * @param userToRoleId 用户关联角色ID
     * @param clientId     执行当前操作的用户所属客户
     */
    public void remove(Long userToRoleId, Long clientId) {

        // 检查待删除的用户和角色关联关系是否存在
        UserToRole userToRole = userToRoleRpService.getById(userToRoleId);
        if (userToRole == null) {
            log.warn("待解除的用户和角色的关联关系不存在,关联关系ID:{}", userToRoleId);
            return;
        }

        // 检查用户绑定的角色是否属于当前客户
        Role role = roleRpService.getById(userToRole.getRoleId());
        if (role.getVisibility()==VisibilityEnum.PRIVATE){
            Assert.state(role.getClientId().equals(clientId),"对私有角色,仅支持解除自建角色");
        }

        // 执行解除动作
        userToRoleRpService.removeById(userToRoleId);
    }


    /**
     * 构建并保存用户和角色的关联关系
     *
     * @param userId   用户ID
     * @param role     待绑定的角色
     * @param clientId 客户ID
     * @param operator 操作人
     */
    private void buildAndSaveUserToRole(Long userId, Role role, Long clientId, Long operator) {
        UserToRole userToRole = new UserToRole();
        userToRole.setClientId(clientId);
        userToRole.setRoleId(role.getId());
        userToRole.setUserId(userId);
        userToRole.setBizDomainId(role.getBizDomainId());
        userToRole.setCreator(operator);
        try {
            userToRoleRpService.save(userToRole);
        } catch (DuplicateKeyException e) {
            log.warn("角色重复绑定的用户,绑定关系:{}", userToRole);
        }
    }

}
