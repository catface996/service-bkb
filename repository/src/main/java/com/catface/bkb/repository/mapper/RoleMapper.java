package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.param.QueryRoleParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 分页查询角色列表
     *
     * @param param 请求参数,客户ID,业务域ID,可见性,角色名称
     * @return 角色分页列表
     */
    List<RoleExd> selectOnePage(@Param("param") QueryRoleParam param);
}
