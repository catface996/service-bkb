package com.catface.bkb.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.bkb.repository.entity.BizDomain;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/14
 */
@Data
public class QueryBizDomainParam extends Page<BizDomain> {

    private String bizDomainName;

    private String bizDomainCode;

}
