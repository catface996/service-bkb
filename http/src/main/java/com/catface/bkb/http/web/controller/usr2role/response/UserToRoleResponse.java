package com.catface.bkb.http.web.controller.usr2role.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/17
 */
@Data
@ApiModel(description = "用户绑定的角色模型")
public class UserToRoleResponse {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "业务域ID")
    private String bizDomainId;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

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
