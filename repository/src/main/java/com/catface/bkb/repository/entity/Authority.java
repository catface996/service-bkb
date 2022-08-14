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
 * 权限点
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Authority对象", description="权限点")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "权限点名称")
    private String authorityName;

    @ApiModelProperty(value = "权限点类型： 查询类和操作类;")
    private String authorityType;

    @ApiModelProperty(value = "所属业务系统编码")
    private String serviceCode;

    @ApiModelProperty(value = "所属业务系统")
    private String serviceName;

    @ApiModelProperty(value = "权限点URL")
    private String url;

    @ApiModelProperty(value = "所属业务域编码")
    private Long bizDomainId;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
