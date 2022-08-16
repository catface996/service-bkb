package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.repository.entity.RoleToAuthGroup;
import com.catface.bkb.repository.entity.exd.RoleToAuthGroupExd;
import com.catface.bkb.repository.param.QueryRoleToAuthGroupParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色关联权限组 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-15
 */
public interface RoleToAuthGroupMapper extends BaseMapper<RoleToAuthGroup> {

    /**
     * 分页查询角色关联的权限组
     *
     * @param param 角色ID,权限组名称,分页信息
     * @return 角色关联的权限组
     */
    List<RoleToAuthGroupExd> selectOnePage(@Param("param") QueryRoleToAuthGroupParam param);
}
