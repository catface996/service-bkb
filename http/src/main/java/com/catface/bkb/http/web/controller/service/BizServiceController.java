package com.catface.bkb.http.web.controller.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.http.config.swagger.SwaggerTagConst;
import com.catface.bkb.http.web.controller.service.convert.BizServiceWebConvert;
import com.catface.bkb.http.web.controller.service.request.GetBizServiceRequest;
import com.catface.bkb.http.web.controller.service.request.SaveServiceRequest;
import com.catface.bkb.http.web.controller.service.response.BizServiceResponse;
import com.catface.bkb.repository.entity.BizService;
import com.catface.bkb.repository.param.QueryBizServiceParam;
import com.catface.bkb.repository.service.BizServiceRpService;
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
@Api(tags = {SwaggerTagConst.BIZ_SERVICE})
@Slf4j
@RestController
public class BizServiceController {

    private final BizServiceRpService bizServiceRpService;

    public BizServiceController(BizServiceRpService bizServiceRpService) {
        this.bizServiceRpService = bizServiceRpService;
    }

    @ApiOperation(value = "保存业务系统")
    @PostMapping(value = "/public/service/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveServiceRequest request) {
        BizService entity = BizServiceWebConvert.convert(request);
        bizServiceRpService.saveOrUpdate(entity);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "分页查询业务系统")
    @PostMapping(value = "/public/service/getOnePage")
    public JsonResult<PageVO<BizServiceResponse>> getOnePage(@RequestBody @Valid GetBizServiceRequest request) {
        QueryBizServiceParam param = BizServiceWebConvert.convert(request);
        Page<BizService> page = bizServiceRpService.queryOnePage(param);
        PageVO<BizServiceResponse> pageVO = BizServiceWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "删除业务系统")
    @PostMapping(value = "/public/service/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid IdRequest request) {
        bizServiceRpService.removeById(request.getId());
        return JsonResult.success(true);
    }
}
