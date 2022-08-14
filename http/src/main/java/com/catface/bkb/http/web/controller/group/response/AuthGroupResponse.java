package com.catface.bkb.http.web.controller.group.response;

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
@ApiModel(description = "权限组模型")
@Data
public class AuthGroupResponse {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "父级权限组")
    private Long parentId;

    @ApiModelProperty(value = "权限组名称")
    private String groupName;

    @ApiModelProperty(value = "所属业务域ID")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属业务域名称")
    private String bizDomainName;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;

}
