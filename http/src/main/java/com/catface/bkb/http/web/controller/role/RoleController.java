package com.catface.bkb.http.web.controller.role;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.role.convert.RoleWebConvert;
import com.catface.bkb.http.web.controller.role.request.*;
import com.catface.bkb.http.web.controller.role.response.RoleResponse;
import com.catface.bkb.http.web.controller.role.response.RoleToAuthResponse;
import com.catface.bkb.repository.entity.Role;
import com.catface.bkb.repository.entity.exd.RoleExd;
import com.catface.bkb.repository.entity.exd.RoleToAuthGroupExd;
import com.catface.bkb.repository.param.QueryRoleParam;
import com.catface.bkb.repository.param.QueryRoleToAuthGroupParam;
import com.catface.bkb.service.role.RoleService;
import com.catface.common.model.JsonResult;
import com.catface.common.model.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author catface
 * @since 2022/8/15
 */
@Api(tags = {SwaggerTagConst.ROLE})
@Slf4j
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value = "保存角色")
    @PostMapping(value = "/public/role/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveRoleRequest request) {
        Role entity = RoleWebConvert.convert(request);
        roleService.save(entity);
        return JsonResult.success();
    }

    @ApiOperation(value = "分页查询公共角色")
    @PostMapping(value = "/public/role/getPublic")
    public JsonResult<PageVO<RoleResponse>> getPublic(@RequestBody @Valid GetPublicRoleRequest request) {
        QueryRoleParam param = RoleWebConvert.convert(request);
        param.setVisibility(VisibilityEnum.PUBLIC);
        Page<RoleExd> page = roleService.queryOnePage(param);
        PageVO<RoleResponse> pageVO = RoleWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "分页查询私有角色")
    @PostMapping(value = "/public/role/getPrivate")
    public JsonResult<PageVO<RoleResponse>> getPrivate(@RequestBody @Valid GetPrivateRoleRequest request) {
        QueryRoleParam param = RoleWebConvert.convert(request);
        param.setVisibility(VisibilityEnum.PRIVATE);
        Page<RoleExd> page = roleService.queryOnePage(param);
        PageVO<RoleResponse> pageVO = RoleWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "删除私有角色")
    @PostMapping(value = "/public/role/deletePrivate")
    public JsonResult<Boolean> deletePrivate(@RequestBody @Valid DeleteRoleRequest request) {
        roleService.deletePrivate(request.getRoleId(), request.getCtxClientId());
        return JsonResult.success();
    }

    @ApiOperation(value = "绑定权限组到角色")
    @PostMapping(value = "/public/role/bindAuthGroup")
    public JsonResult<Boolean> bindAuthGroup(@RequestBody @Valid BindGroupToRoleRequest request) {
        roleService.bindAuthGroup(request.getRoleId(), request.getAuthGroupId(), request.getCtxClientId(),
                request.getCtxUserId());
        return JsonResult.success();
    }

    @ApiOperation(value = "获取角色绑定的权限组")
    @PostMapping(value = "/public/role/getAuthGroup")
    public JsonResult<PageVO<RoleToAuthResponse>> getAuthGroup(@RequestBody @Valid GetRoleToAuthGroupRequest request) {
        QueryRoleToAuthGroupParam param = RoleWebConvert.convert(request);
        Page<RoleToAuthGroupExd> page = roleService.queryAuthGroup(param, request.getCtxClientId());
        PageVO<RoleToAuthResponse> pageVO = RoleWebConvert.convertRoleToAuthGroup(page);
        return JsonResult.success(pageVO);
    }


    @ApiOperation(value = "删除角色关联的权限组")
    @PostMapping(value = "/public/role/removeAuthGroup")
    public JsonResult<Boolean> removeAuthGroup(@RequestBody @Valid RemoveAuthGroupFromRoleRequest request) {
        return JsonResult.success();
    }


}
