package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.repository.entity.UserToRole;
import com.catface.bkb.repository.entity.exd.UserToRoleExd;
import com.catface.bkb.repository.param.QueryUserToRoleParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户关联角色 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface UserToRoleMapper extends BaseMapper<UserToRole> {

    /**
     * 分页查询用户关联的角色
     *
     * @param param 客户,用户,角色,业务域,分页信息
     * @return 用户和角色的关联
     */
    List<UserToRoleExd> selectOnePage(@Param("param") QueryUserToRoleParam param);
}
