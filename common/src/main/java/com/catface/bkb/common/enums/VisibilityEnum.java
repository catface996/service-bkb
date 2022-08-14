package com.catface.bkb.common.enums;

import com.catface.common.enums.BaseEnum;

/**
 * @author catface
 * @since 2022/8/14
 */
public enum VisibilityEnum implements BaseEnum {

    /**
     * 可见性枚举值,public:所有客户可见;private:仅客户自己可见;SYSTEM:系统级,仅开发同学可见;
     */
    PUBLIC("PUBLIC","公开"),

    PRIVATE("PRIVATE","私有"),

    SYSTEM("SYSTEM","系统级")
    ;

    private final String code;

    private final String desc;

    VisibilityEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 获取枚举值描述
     *
     * @return 枚举值描述
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * 获取枚举值编码
     *
     * @return 枚举值编码
     */
    @Override
    public String getCode() {
        return code;
    }
}
