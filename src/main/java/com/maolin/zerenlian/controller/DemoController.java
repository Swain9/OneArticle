package com.maolin.zerenlian.controller;

import com.maolin.zerenlian.model.BizRequest;
import com.maolin.zerenlian.model.BizResponse;
import com.maolin.zerenlian.proxy.ServiceFactory;
import com.maolin.zerenlian.service.DemoService;

/**
 * <PRE>
 * 业务
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:18
 */
public class DemoController {

    private DemoService demoService = ServiceFactory.getInstance().createApi(DemoService.class);

    public BizResponse test1(BizRequest request) {
        return demoService.test1(request);
    }

}
