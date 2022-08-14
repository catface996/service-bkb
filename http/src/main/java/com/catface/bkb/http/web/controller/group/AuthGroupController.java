package com.catface.bkb.http.web.controller.group;

import com.catface.bkb.http.web.controller.group.request.GetAuthGroupChildrenRequest;
import com.catface.bkb.http.web.controller.group.request.SaveAuthGroupRequest;
import com.catface.bkb.http.web.controller.group.response.AuthGroupResponse;
import com.catface.common.model.JsonResult;
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
@Slf4j
@RestController
public class AuthGroupController {


    @ApiOperation(value = "保存权限组")
    @PostMapping(value = "/public/authGroup/save")
    public JsonResult<SaveAuthGroupRequest> save(@RequestBody @Valid SaveAuthGroupRequest request) {
        return JsonResult.success();
    }

    @ApiOperation(value = "根据父级权限组查询下一级权限组")
    @PostMapping(value = "")
    public JsonResult<List<AuthGroupResponse>> getChildren(@RequestBody@Valid GetAuthGroupChildrenRequest request){

    }



}
