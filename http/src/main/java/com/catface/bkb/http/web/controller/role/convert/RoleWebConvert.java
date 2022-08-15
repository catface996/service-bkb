package com.catface.bkb.http.web.controller.role.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.web.controller.role.request.GetPrivateRoleRequest;
import com.catface.bkb.http.web.controller.role.request.GetPublicRoleRequest;
import com.catface.bkb.http.web.controller.role.request.SaveRoleRequest;
import com.catface.bkb.http.web.controller.role.response.RoleResponse;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.param.QueryRoleParam;
import com.catface.common.model.PageVO;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/15
 */
public class RoleWebConvert {

    private static final BeanCopier SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveRoleRequest.class, Role.class, false);

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(RoleExd.class, RoleResponse.class, false);

    public static Role convert(SaveRoleRequest request) {
        Role entity = new Role();
        Date date = DateTime.now().toDate();
        SAVE_REQUEST_2_ENTITY.copy(request, entity, null);
        entity.setClientId(request.getCtxClient());
        if (entity.getId() == null) {
            entity.setCreator(request.getCtxUserId());
            entity.setCreated(date);
        }
        entity.setUpdated(date);
        entity.setModifier(request.getCtxUserId());
        return entity;
    }

    public static QueryRoleParam convert(GetPublicRoleRequest request) {
        QueryRoleParam param = new QueryRoleParam();
        param.setRoleName(request.getRoleName());
        param.setBizDomainId(request.getBizDomainId());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static QueryRoleParam convert(GetPrivateRoleRequest request) {
        QueryRoleParam param = new QueryRoleParam();
        param.setRoleName(request.getRoleName());
        param.setBizDomainId(request.getBizDomainId());
        param.setClientId(request.getCtxClientId());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static RoleResponse convert(RoleExd entity) {
        RoleResponse response = new RoleResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<RoleResponse> convert(List<RoleExd> entities) {
        List<RoleResponse> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)) {
            return list;
        }
        for (RoleExd entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<RoleResponse> convert(Page<RoleExd> page) {
        PageVO<RoleResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<RoleResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }
}
