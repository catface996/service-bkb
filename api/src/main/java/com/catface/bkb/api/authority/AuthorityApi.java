package com.catface.bkb.api.authority;

import com.catface.bkb.api.authority.request.CheckAuthorityRequest;
import com.catface.common.model.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author catface
 * @since 2022/8/18
 */
@FeignClient(name = "authorityApi", url = "${rpc.bkb.service}", fallbackFactory = AuthorityApiFallback.class)
public interface AuthorityApi {

    /**
     * 检查用户在指定的客户下,是否有指定接口的访问权限
     *
     * @param request 用户,客户,业务域,url
     * @return true:允许访问;false:不允许访问;
     */
    @PostMapping(value = "/private/authority/canAccess")
    JsonResult<Boolean> canAccess(@RequestBody @Valid CheckAuthorityRequest request);
}
