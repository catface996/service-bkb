package com.catface.bkb.http.web.controller.group.convert;

import com.catface.bkb.http.web.controller.group.request.SaveAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.response.AuthGroupResponse;
import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.service.group.param.SaveAuthGroupParam;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/15
 */
public class AuthGroupWebConvert {

    private static final BeanCopier SAVE_REQUEST_2_PARAM = BeanCopier.create(SaveAuthGroupRequest.class, SaveAuthGroupParam.class, false);

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(AuthGroup.class, AuthGroupResponse.class,false);

    public static SaveAuthGroupParam convert(SaveAuthGroupRequest request){
        SaveAuthGroupParam param = new SaveAuthGroupParam();
        SAVE_REQUEST_2_PARAM.copy(request,param,null);
        param.setOperator(request.getCtxUserId());
        param.setClientId(request.getCtxClientId());
        return param;
    }

    public static AuthGroupResponse convert(AuthGroup entity){
        AuthGroupResponse response = new AuthGroupResponse();
        ENTITY_2_RESPONSE.copy(entity,response,null);
        return response;
    }

    public static List<AuthGroupResponse> convert(List<AuthGroup> entities){
        List<AuthGroupResponse> list = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)){
            return list;
        }
        for (AuthGroup entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }


}
