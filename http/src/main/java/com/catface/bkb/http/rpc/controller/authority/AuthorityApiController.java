package com.catface.bkb.http.rpc.controller.authority;

import com.catface.bkb.api.authority.AuthorityApi;
import com.catface.bkb.api.authority.request.CheckAuthorityRequest;
import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.service.authority.AuthorityService;
import com.catface.common.model.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author catface
 * @since 2022/8/18
 */
@Api(tags = {SwaggerTagConst.AUTHORITY})
@RestController
public class AuthorityApiController implements AuthorityApi {

    private final AuthorityService authorityService;

    public AuthorityApiController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    /**
     * 检查用户在指定的客户下,是否有指定接口的访问权限
     *
     * @param request 用户,客户,业务域,url
     * @return true:允许访问;false:不允许访问;
     */
    @Override
    public JsonResult<Boolean> canAccess(CheckAuthorityRequest request) {
        boolean result = authorityService.checkAuthority(request.getClientId(), request.getUserId(), request.getBizDomainCode(), request.getUrl());
        return JsonResult.success(result);
    }
}
