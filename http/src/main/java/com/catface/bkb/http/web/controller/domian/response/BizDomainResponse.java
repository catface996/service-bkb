package com.catface.bkb.http.web.controller.domian.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "业务域模型")
@Data
public class BizDomainResponse {

    @ApiModelProperty(value = "主键")
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
