package com.catface.bkb.http.web.controller.role.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catface.bkb.common.enums.VisibilityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/15
 */
@ApiModel(description = "保存角色请求")
@Data
public class SaveRoleRequest {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属业务域ID",required = true,example = "1234567890")
    @NotNull(message = "所属业务域ID不能为空")
    private Long bizDomainId;

    @ApiModelProperty(value = "角色名称",required = true,example = "仓库管理员")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @ApiModelProperty(value = "当前会话操作的客户ID",required = true,example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClient;

    @ApiModelProperty(value = "当前会话的用户ID",required = true,example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "备注")
    private String remark;
}
