package com.catface.bkb.http.web.controller.role.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catface.bkb.common.enums.VisibilityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/15
 */
@Data
@ApiModel(description = "角色模型")
public class RoleResponse {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属业务域名称")
    private String bizDomainName;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "可见性")
    private VisibilityEnum visibility;

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
