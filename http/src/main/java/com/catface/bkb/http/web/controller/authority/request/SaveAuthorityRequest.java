package com.catface.bkb.http.web.controller.authority.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catface.bkb.common.enums.AuthorityTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class SaveAuthorityRequest {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "权限点名称",required = true,example = "新增用户")
    @NotBlank(message = "权限点名称不能为空")
    private String authorityName;

    @ApiModelProperty(value = "权限点类型： 查询类和操作类;",required = true,example = "BUTTON")
    @NotNull(message = "权限点类型不能为空")
    private AuthorityTypeEnum authorityType;

    @ApiModelProperty(value = "权限点URL")
    private String url;

    @ApiModelProperty(value = "所属业务系统编码")
    private Long bizServiceId;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属权限组ID")
    private Long authGroupId;

    @ApiModelProperty(value = "备注")
    private String remark;
}
