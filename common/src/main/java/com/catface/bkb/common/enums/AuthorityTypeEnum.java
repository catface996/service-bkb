package com.catface.bkb.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.catface.common.enums.BaseEnum;

/**
 * @author catface
 * @since 2022/8/14
 */
public enum AuthorityTypeEnum implements BaseEnum {

    /**
     * 权限点类型
     */
    MENU("MENU","菜单"),
    PAGE("PAGE","页面"),
    BUTTON("BUTTON","按钮")
    ;

    @EnumValue
    private final String code;

    private final String desc;

    AuthorityTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getCode() {
        return code;
    }
}
