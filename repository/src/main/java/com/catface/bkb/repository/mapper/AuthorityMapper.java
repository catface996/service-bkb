package com.catface.bkb.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.exd.AuthorityExd;
import com.catface.bkb.repository.param.QueryAuthorityParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限点 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 分页查询权限点
     *
     * @param param 分页查询参数
     * @return 权限点列表
     */
    List<AuthorityExd> selectOnePage(@Param("param") QueryAuthorityParam param);

    /**
     * 根据业务域和url查询权限点
     *
     * @param bizDomainId 业务域ID
     * @param url         url
     * @return 权限点
     */
    Authority selectByBizDomainUrl(@Param("bizDomainId") Long bizDomainId, @Param("url") String url);
}
