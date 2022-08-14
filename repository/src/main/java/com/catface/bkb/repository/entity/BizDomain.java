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
 * 业务域
 * </p>
 *
 * @author catface
 * @since 2022-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BizDomain对象", description="业务域")
public class BizDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "业务域名称")
    private String bizDomainName;

    @ApiModelProperty(value = "业务域编码，可以使用域名")
    private String bizDomainCode;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
