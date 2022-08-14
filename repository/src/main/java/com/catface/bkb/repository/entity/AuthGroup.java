package com.catface.bkb.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catface.bkb.common.enums.VisibilityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 权限组
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "AuthGroup对象", description = "权限组")
public class AuthGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "父级权限组")
    private Long parentId;

    @ApiModelProperty(value = "权限组名称")
    private String groupName;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "可见性")
    private VisibilityEnum visibility;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
