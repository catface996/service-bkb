package com.catface.bkb.http.web.controller.role.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/16
 */
@Data
@ApiModel(description = "角色关联权限组模型")
public class RoleToAuthResponse {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限组ID")
    private Long authGroupId;

    @ApiModelProperty(value = "权限组名称")
    private String authGroupName;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "备注")
    private String remark;
}
