package com.catface.bkb.http.web.controller.domian.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "保存业务域请求")
@Data
public class SaveBizDomainRequest {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务域名称",required = true,example = "saas系统")
    @NotBlank(message = "业务域名称不能为空")
    private String bizDomainName;

    @ApiModelProperty(value = "业务域编码，可以使用域名",required = true,example = "saas")
    @NotBlank(message = "业务域编码不能为空")
    private String bizDomainCode;

    @ApiModelProperty(value = "备注")
    private String remark;
}
