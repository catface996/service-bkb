package com.catface.bkb.http.web.controller.service.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.web.controller.service.request.GetBizServiceRequest;
import com.catface.bkb.http.web.controller.service.request.SaveServiceRequest;
import com.catface.bkb.http.web.controller.service.response.BizServiceResponse;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.param.QueryBizServiceParam;
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
public class BizServiceConvert {

    private final static BeanCopier SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveServiceRequest.class, BizService.class, false);

    private final static BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(BizService.class, BizServiceResponse.class, false);

    private final static BeanCopier GET_ONE_PAGE_REQUEST_2_PARAM = BeanCopier.create(GetBizServiceRequest.class, QueryBizServiceParam.class, false);

    public static BizService convert(SaveServiceRequest request) {
        BizService entity = new BizService();
        SAVE_REQUEST_2_ENTITY.copy(request, entity, null);
        if (entity.getId() != null) {
            entity.setUpdated(DateTime.now().toDate());
        }
        return entity;
    }

    public static BizServiceResponse convert(BizService entity) {
        BizServiceResponse response = new BizServiceResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<BizServiceResponse> convert(List<BizService> entities) {
        List<BizServiceResponse> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)) {
            return list;
        }
        for (BizService entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<BizServiceResponse> convert(Page<BizService> page) {
        PageVO<BizServiceResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<BizServiceResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }

    public static QueryBizServiceParam convert(GetBizServiceRequest request) {
        QueryBizServiceParam param = new QueryBizServiceParam();
        GET_ONE_PAGE_REQUEST_2_PARAM.copy(request, param, null);
        return param;
    }

}
