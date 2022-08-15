package com.catface.bkb.http.web.controller.group;

import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.group.convert.AuthGroupWebConvert;
import com.catface.bkb.http.web.controller.group.request.DeleteAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.request.GetAuthGroupChildrenRequest;
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
    @PostMapping(value = "/public/authGroup/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveAuthGroupRequest request) {
        SaveAuthGroupParam param = AuthGroupWebConvert.convert(request);
        authGroupService.save(param);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "根据父级权限组查询下一级权限组")
    @PostMapping(value = "/public/authGroup/getChildren")
    public JsonResult<List<AuthGroupResponse>> getChildren(@RequestBody @Valid GetAuthGroupChildrenRequest request) {
        List<AuthGroup> list = authGroupService.queryChildren(request.getVisibility(), request.getBizDomainId(),
                request.getCtxClientId(), request.getParentId());
        List<AuthGroupResponse> responses = AuthGroupWebConvert.convert(list);
        return JsonResult.success(responses);
    }

    @ApiOperation(value = "删除权限组")
    @PostMapping(value = "/public/authGroup/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid DeleteAuthGroupRequest request) {
        authGroupService.delete(request.getId(), request.getCtxClientId());
        return JsonResult.success(true);
    }


}
