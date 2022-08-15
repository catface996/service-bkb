package com.catface.bkb.http.web.controller.authority.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.web.controller.authority.request.GetAuthorityRequest;
import com.catface.bkb.http.web.controller.authority.request.SaveAuthorityRequest;
import com.catface.bkb.http.web.controller.authority.response.AuthorityResponse;
import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.exd.AuthorityExd;
import com.catface.bkb.repository.param.QueryAuthorityParam;
import com.catface.common.model.PageVO;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/14
 */
public class AuthorityWebConvert {

    private static final BeanCopier SAVE_AUTHORITY_REQUEST_2_ENTITY = BeanCopier.create(SaveAuthorityRequest.class, Authority.class, false);

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(AuthorityExd.class, AuthorityResponse.class, false);

    private static final BeanCopier GET_AUTHORITY_REQUEST_2_PARAM = BeanCopier.create(GetAuthorityRequest.class, QueryAuthorityParam.class, false);

    public static Authority convert(SaveAuthorityRequest request) {
        Authority entity = new Authority();
        SAVE_AUTHORITY_REQUEST_2_ENTITY.copy(request, entity, null);
        if (entity.getId() != null) {
            entity.setUpdated(DateTime.now().toDate());
        }
        return entity;
    }

    public static QueryAuthorityParam convert(GetAuthorityRequest request) {
        QueryAuthorityParam param = new QueryAuthorityParam();
        GET_AUTHORITY_REQUEST_2_PARAM.copy(request, param, null);
        param.setSize(request.getSize());
        param.setCurrent(request.getCurrent());
        return param;
    }

    public static AuthorityResponse convert(AuthorityExd entity) {
        AuthorityResponse response = new AuthorityResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<AuthorityResponse> convert(List<AuthorityExd> entities) {
        List<AuthorityResponse> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)) {
            return list;
        }
        for (AuthorityExd entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<AuthorityResponse> convert(Page<AuthorityExd> page) {
        PageVO<AuthorityResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<AuthorityResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }
}
