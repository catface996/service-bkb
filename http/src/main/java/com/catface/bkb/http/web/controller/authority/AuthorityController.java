package com.catface.bkb.http.web.controller.authority;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.authority.convert.AuthorityWebConvert;
import com.catface.bkb.http.web.controller.authority.request.GetAuthorityRequest;
import com.catface.bkb.http.web.controller.authority.request.SaveAuthorityRequest;
import com.catface.bkb.http.web.controller.authority.response.AuthorityResponse;
import com.catface.bkb.repository.entity.Authority;
import com.catface.bkb.repository.entity.exd.AuthorityExd;
import com.catface.bkb.repository.param.QueryAuthorityParam;
import com.catface.bkb.repository.service.AuthorityRpService;
import com.catface.bkb.service.authority.AuthorityService;
import com.catface.common.model.IdRequest;
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
 * @since 2022/8/14
 */
@Api(tags = {SwaggerTagConst.AUTHORITY})
@Slf4j
@RestController
public class AuthorityController {

    private final AuthorityRpService authorityRpService;

    private final AuthorityService authorityService;

    public AuthorityController(AuthorityRpService authorityRpService, AuthorityService authorityService) {
        this.authorityRpService = authorityRpService;
        this.authorityService = authorityService;
    }

    @ApiOperation(value = "保存权限点")
    @PostMapping(value = "/public/authority/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveAuthorityRequest request) {
        Authority entity = AuthorityWebConvert.convert(request);
        authorityService.save(entity);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "分页查询权限点")
    @PostMapping(value = "/public/authority/getOnePage")
    public JsonResult<PageVO<AuthorityResponse>> getOnePage(@RequestBody @Valid GetAuthorityRequest request) {
        QueryAuthorityParam param = AuthorityWebConvert.convert(request);
        Page<AuthorityExd> page = authorityRpService.queryOnePage(param);
        PageVO<AuthorityResponse> pageVO = AuthorityWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "删除权限点")
    @PostMapping(value = "/public/authority/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid IdRequest request) {
        authorityRpService.removeById(request.getId());
        return JsonResult.success(true);
    }



}
