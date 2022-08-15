package com.catface.bkb.http.web.controller.group.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/14
 */
@ApiModel(description = "保存权限组请求")
@Data
public class SaveAuthGroupRequest {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "父级权限组")
    private Long parentId;

    @ApiModelProperty(value = "当前登录的用户所操作的客户ID",required = true,example = "987654321")
    @NotNull(message = "当前操作的客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "当前登录的用户ID",required = true,example = "123456789")
    @NotNull(message = "当前登录的用户ID")
    private Long ctxUserId;

    @ApiModelProperty(value = "权限组名称",required = true,example = "库区管理")
    @NotBlank(message = "权限组名称不能为空")
    private String groupName;

    @ApiModelProperty(value = "所属业务域ID",required = true,example = "123456789")
    @NotNull(message = "所属业务域不能为空")
    private Long bizDomainId;

    @ApiModelProperty(value = "备注")
    private String remark;

}
