package com.catface.bkb.http.web.controller.usr2role;

import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.usr2role.reqeust.BindRoleToUserRequest;
import com.catface.bkb.http.web.controller.usr2role.reqeust.GetUserToRoleRequest;
import com.catface.bkb.http.web.controller.usr2role.reqeust.RemoveRoleFromUserRequest;
import com.catface.bkb.http.web.controller.usr2role.response.UserToRoleResponse;
import com.catface.bkb.service.user2role.UserToRoleService;
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
 * @since 2022/8/17
 */
@Api(tags = {SwaggerTagConst.USER_TO_ROLE})
@Slf4j
@RestController
public class UserToRoleController {

    private final UserToRoleService userToRoleService;

    public UserToRoleController(UserToRoleService userToRoleService) {
        this.userToRoleService = userToRoleService;
    }

    @ApiOperation(value = "绑定角色到用户")
    @PostMapping(value = "/public/user2role/bind")
    public JsonResult<Boolean> bind(@RequestBody @Valid BindRoleToUserRequest request) {
        userToRoleService.bind(request.getBindUserId(), request.getBindRoleId(), request.getCtxClientId(), request.getCtxUserId());
        return JsonResult.success(true);
    }

    @ApiOperation(value = "解绑用户绑定的角色")
    @PostMapping(value = "/public/user2role/remove")
    public JsonResult<Boolean> remove(@RequestBody @Valid RemoveRoleFromUserRequest request) {
        userToRoleService.remove(request.getUserToRoleId(), request.getCtxClientId());
        return JsonResult.success(true);
    }

    @ApiOperation(value = "分页查询用户和角色的绑定关系")
    @PostMapping(value = "/public/user2role/getOnePage")
    public JsonResult<PageVO<UserToRoleResponse>> getOnePage(@RequestBody @Valid GetUserToRoleRequest request) {
        return JsonResult.success();
    }
}
