package com.catface.bkb.service.group;

import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.service.group.param.SaveAuthGroupParam;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/14
 */
public interface AuthGroupService {

    /**
     * 保存权限组
     * @param param 保存权限组的参数
     */
    void save(SaveAuthGroupParam param);

    /**
     * 根据上一级的ID查询下一级的权限组
     *
     * @param visibility  可见性
     * @param bizDomainId 所属业务域
     * @param clientId    所属客户ID
     * @param parentId    上一级的权限组ID
     * @return 下一级的权限组列表
     */
    List<AuthGroup> queryChildren(VisibilityEnum visibility,Long bizDomainId,Long clientId,Long parentId);

    /**
     * 删除权限组,仅当所属客户一致,且为PRIVATE的权限组
     * @param id 权限组ID
     * @param clientId 所属客户ID
     */
    void delete(Long id,Long clientId);
}
