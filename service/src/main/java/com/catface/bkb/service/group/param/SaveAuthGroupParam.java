package com.catface.bkb.service.group.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class SaveAuthGroupParam {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "父级权限组")
    private Long parentId;

    @ApiModelProperty(value = "当前登录的用户所操作的客户ID",required = true,example = "987654321")
    private Long ctxClientId;

    @ApiModelProperty(value = "当前登录的用户ID",required = true,example = "123456789")
    private Long ctxUserId;

    @ApiModelProperty(value = "权限组名称",required = true,example = "库区管理")
    private String groupName;

    @ApiModelProperty(value = "所属业务域ID",required = true,example = "123456789")
    private Long bizDomainId;

    @ApiModelProperty(value = "备注")
    private String remark;
}
