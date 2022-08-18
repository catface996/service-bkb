package com.catface.bkb.http.web.controller.usr2role.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.web.controller.usr2role.reqeust.GetUserToRoleRequest;
import com.catface.bkb.http.web.controller.usr2role.response.UserToRoleResponse;
import com.catface.bkb.repository.entity.exd.UserToRoleExd;
import com.catface.bkb.repository.param.QueryUserToRoleParam;
import com.catface.common.model.PageVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/18
 */
public class UserToRoleWebConvert {

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(UserToRoleExd.class, UserToRoleResponse.class, false);

    public static QueryUserToRoleParam convert(GetUserToRoleRequest request) {
        QueryUserToRoleParam param = new QueryUserToRoleParam();
        param.setClientId(request.getCtxClientId());
        param.setUserId(request.getUserId());
        param.setRoleId(request.getRoleId());
        param.setBizDomainId(request.getBizDomainId());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static UserToRoleResponse convert(UserToRoleExd entity) {
        UserToRoleResponse response = new UserToRoleResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<UserToRoleResponse> convert(List<UserToRoleExd> entities) {
        List<UserToRoleResponse> list = new ArrayList<>();
        for (UserToRoleExd entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<UserToRoleResponse> convert(Page<UserToRoleExd> page) {
        PageVO<UserToRoleResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<UserToRoleResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }

}
