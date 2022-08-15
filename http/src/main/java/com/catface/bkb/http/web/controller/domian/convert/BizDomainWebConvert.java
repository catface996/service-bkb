package com.catface.bkb.http.web.controller.domian.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.web.controller.domian.request.GetBizDomainRequest;
import com.catface.bkb.http.web.controller.domian.request.SaveBizDomainRequest;
import com.catface.bkb.http.web.controller.domian.response.BizDomainResponse;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.param.QueryBizDomainParam;
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
public class BizDomainWebConvert {

    private static final BeanCopier SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveBizDomainRequest.class, BizDomain.class, false);

    private static final BeanCopier GET_BIZ_DOMAIN_REQUEST_2_PARAM = BeanCopier.create(GetBizDomainRequest.class, QueryBizDomainParam.class, false);

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(BizDomain.class, BizDomainResponse.class, false);

    public static BizDomain convert(SaveBizDomainRequest request) {
        BizDomain entity = new BizDomain();
        SAVE_REQUEST_2_ENTITY.copy(request, entity, null);
        if (entity.getId() != null) {
            entity.setUpdated(DateTime.now().toDate());
        }
        return entity;
    }

    public static BizDomainResponse convert(BizDomain entity) {
        BizDomainResponse response = new BizDomainResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<BizDomainResponse> convert(List<BizDomain> entities) {
        List<BizDomainResponse> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)) {
            return list;
        }
        for (BizDomain entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<BizDomainResponse> convert(Page<BizDomain> page) {
        PageVO<BizDomainResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<BizDomainResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }

    public static QueryBizDomainParam convert(GetBizDomainRequest request) {
        QueryBizDomainParam param = new QueryBizDomainParam();
        GET_BIZ_DOMAIN_REQUEST_2_PARAM.copy(request, param, null);
        param.setSize(request.getSize());
        param.setCurrent(request.getCurrent());
        return param;
    }
}
