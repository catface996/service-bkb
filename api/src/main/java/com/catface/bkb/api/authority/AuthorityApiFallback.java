package com.catface.bkb.api.authority;

import com.catface.bkb.api.authority.request.CheckAuthorityRequest;
import com.catface.common.model.JsonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author catface
 * @since 2022/8/18
 */
@Slf4j
@Component
public class AuthorityApiFallback implements FallbackFactory<AuthorityApi> {

    @Override
    public AuthorityApi create(Throwable cause) {
        return new AuthorityApi() {
            @Override
            public JsonResult<Boolean> canAccess(CheckAuthorityRequest request) {
                log.error("远程调用权限校验接口异常,request:{}", request, cause);
                return JsonResult.rpcError("远程调用权限校验接口异常");
            }
        };
    }
}
