package com.catface.bkb.repository.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 业务系统
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "BizService对象", description = "业务系统")
public class BizService implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "服务名")
    private String bizServiceName;

    @ApiModelProperty(value = "服务编码,一般是服务的域名")
    private String bizServiceCode;

    @ApiModelProperty(value = "获取权限数据的接入点")
    private String authEndpoint;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
