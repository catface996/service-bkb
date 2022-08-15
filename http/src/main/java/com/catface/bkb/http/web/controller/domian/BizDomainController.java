package com.catface.bkb.http.web.controller.domian;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.domian.convert.BizDomainWebConvert;
import com.catface.bkb.http.web.controller.domian.request.GetBizDomainRequest;
import com.catface.bkb.http.web.controller.domian.request.SaveBizDomainRequest;
import com.catface.bkb.http.web.controller.domian.response.BizDomainResponse;
import com.catface.bkb.repository.entity.BizDomain;
import com.catface.bkb.repository.param.QueryBizDomainParam;
import com.catface.bkb.repository.service.BizDomainRpService;
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
@Api(tags = {SwaggerTagConst.BIZ_DOMAIN})
@Slf4j
@RestController
public class BizDomainController {

    private final BizDomainRpService bizDomainRpService;

    public BizDomainController(BizDomainRpService bizDomainRpService) {
        this.bizDomainRpService = bizDomainRpService;
    }

    @ApiOperation(value = "保存业务域")
    @PostMapping(value = "/public/domain/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveBizDomainRequest request) {
        BizDomain entity = BizDomainWebConvert.convert(request);
        bizDomainRpService.saveOrUpdate(entity);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "分页查询业务域")
    @PostMapping(value = "/public/domain/getOnePage")
    public JsonResult<PageVO<BizDomainResponse>> getOnePage(@RequestBody @Valid GetBizDomainRequest request) {
        QueryBizDomainParam param = BizDomainWebConvert.convert(request);
        Page<BizDomain> page = bizDomainRpService.queryOnePage(param);
        PageVO<BizDomainResponse> pageVO = BizDomainWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "删除业务域")
    @PostMapping(value = "/public/domain/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid IdRequest request) {
        bizDomainRpService.removeById(request.getId());
        return JsonResult.success(true);
    }

}
