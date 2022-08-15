package com.catface.bkb.http.web.controller.group;

import com.catface.bkb.common.enums.VisibilityEnum;
import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.group.convert.AuthGroupWebConvert;
import com.catface.bkb.http.web.controller.group.request.DeleteAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.request.GetPrivateAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.request.GetPublicAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.request.SaveAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.response.AuthGroupResponse;
import com.catface.bkb.repository.entity.AuthGroup;
import com.catface.bkb.service.group.AuthGroupService;
import com.catface.bkb.service.group.param.SaveAuthGroupParam;
import com.catface.common.model.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/14
 */
@Api(tags = {SwaggerTagConst.AUTH_GROUP})
@Slf4j
@RestController
public class AuthGroupController {

    private final AuthGroupService authGroupService;

    public AuthGroupController(AuthGroupService authGroupService) {
        this.authGroupService = authGroupService;
    }

    @ApiOperation(value = "保存权限组")
    @PostMapping(value = "/public/authGroup/savePrivate")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveAuthGroupRequest request) {
        SaveAuthGroupParam param = AuthGroupWebConvert.convert(request);
        authGroupService.save(param);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "查询公共权限组")
    @PostMapping(value = "/public/authGroup/getPublic")
    public JsonResult<List<AuthGroupResponse>> getPublic(@RequestBody @Valid GetPublicAuthGroupRequest request) {
        List<AuthGroup> list = authGroupService.queryChildren(VisibilityEnum.PUBLIC, request.getBizDomainId(),
                null, request.getParentId());
        List<AuthGroupResponse> responses = AuthGroupWebConvert.convert(list);
        return JsonResult.success(responses);
    }

    @ApiOperation(value = "查询私有权限组")
    @PostMapping(value = "/public/authGroup/getPrivate")
    public JsonResult<List<AuthGroupResponse>> getPrivate(@RequestBody @Valid GetPrivateAuthGroupRequest request) {
        List<AuthGroup> list = authGroupService.queryChildren(VisibilityEnum.PRIVATE, request.getBizDomainId(),
                request.getCtxClientId(), request.getParentId());
        List<AuthGroupResponse> responses = AuthGroupWebConvert.convert(list);
        return JsonResult.success(responses);
    }


    @ApiOperation(value = "删除私有权限组")
    @PostMapping(value = "/public/authGroup/deletePrivate")
    public JsonResult<Boolean> deletePrivate(@RequestBody @Valid DeleteAuthGroupRequest request) {
        authGroupService.delete(request.getId(), request.getCtxClientId());
        return JsonResult.success(true);
    }


}
