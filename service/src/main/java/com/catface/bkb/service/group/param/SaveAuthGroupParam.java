package com.catface.bkb.service.group.param;

import com.catface.bkb.common.enums.VisibilityEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    @ApiModelProperty(value = "权限组名称", required = true, example = "库区管理")
    private String groupName;

    @ApiModelProperty(value = "所属业务域ID", required = true, example = "123456789")
    private Long bizDomainId;

    @ApiModelProperty(value = "所属客户ID", required = true, example = "987654321")
    private Long clientId;

    @ApiModelProperty(value = "操作人", required = true, example = "123456789")
    private Long operator;

    @ApiModelProperty(value = "可见性", example = "PRIVATE")
    private VisibilityEnum visibility;

    @ApiModelProperty(value = "备注")
    private String remark;
}
