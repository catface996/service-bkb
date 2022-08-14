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
 * 用户关联角色
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserToRole对象", description="用户关联角色")
public class UserToRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务域ID")
    @TableId(value = "biz_domain_id", type = IdType.ASSIGN_ID)
    private String bizDomainId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "客户ID")
    private Long clientId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
