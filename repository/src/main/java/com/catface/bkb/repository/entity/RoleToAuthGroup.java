package com.catface.bkb.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色关联权限组
 * </p>
 *
 * @author catface
 * @since 2022-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RoleToAuthGroup对象", description="角色关联权限组")
public class RoleToAuthGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限组ID")
    private Long authGroupId;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "备注")
    private String remark;


}
