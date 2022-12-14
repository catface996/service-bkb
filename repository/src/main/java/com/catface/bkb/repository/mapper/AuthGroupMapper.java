package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.repository.entity.AuthGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限组 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface AuthGroupMapper extends BaseMapper<AuthGroup> {

    /**
     * 根据可见性,客户ID,以及parent查询下一级的权限组
     *
     * @param visibility  可见性
     * @param bizDomainId 所属业务域ID
     * @param clientId    客户ID
     * @param parentId    父级权限组的ID
     * @return 下一级的权限组
     */
    List<AuthGroup> selectChildren(@Param("visibility") VisibilityEnum visibility,
                                   @Param("bizDomainId") Long bizDomainId,
                                   @Param("clientId") Long clientId,
                                   @Param("parentId") Long parentId);

    /**
     * 统计客户创建的权限组个数
     *
     * @param clientId 客户ID
     * @return 客户创建的权限组的个数
     */
    Integer countByClientId(@Param("clientId") Long clientId);
}
