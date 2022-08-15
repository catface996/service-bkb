package com.catface.bkb.service.group.convert;

import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.service.group.param.SaveAuthGroupParam;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/15
 */
public class AuthGroupServiceConvert {

    private static final BeanCopier SAVE_PARAM_2_ENTITY = BeanCopier.create(SaveAuthGroupParam.class, AuthGroup.class, false);

    public static AuthGroup convert(SaveAuthGroupParam param) {
        AuthGroup entity = new AuthGroup();
        Date date = DateTime.now().toDate();
        SAVE_PARAM_2_ENTITY.copy(param, entity, null);
        if (entity.getId()==null){
            entity.setCreator(param.getOperator());
            entity.setCreated(date);
        }
        entity.setModifier(param.getOperator());
        entity.setUpdated(date);
        return entity;
    }
}
