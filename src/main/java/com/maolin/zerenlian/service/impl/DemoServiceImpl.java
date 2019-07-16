package com.maolin.zerenlian.service.impl;

import com.maolin.zerenlian.annotation.BizService;
import com.maolin.zerenlian.annotation.ParamsHandle;
import com.maolin.zerenlian.handle.LoginParamsHandleImpl;
import com.maolin.zerenlian.handle.ScriptParamsHandleImpl;
import com.maolin.zerenlian.handle.Test1ParamsHandleImpl;
import com.maolin.zerenlian.model.BizRequest;
import com.maolin.zerenlian.model.BizResponse;
import com.maolin.zerenlian.service.DemoService;

/**
 * <PRE>
 * 实现类
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:37
 */
@BizService
public class DemoServiceImpl implements DemoService {
    /**
     * test1
     *
     * @param bizRequest 请求参数
     * @return 响应参数
     */
    @Override
    @ParamsHandle(clazz = LoginParamsHandleImpl.class, index = 1)
    @ParamsHandle(clazz = ScriptParamsHandleImpl.class, index = 3)
    @ParamsHandle(clazz = Test1ParamsHandleImpl.class, index = 2)
    public BizResponse test1(BizRequest bizRequest) {
        System.out.println(bizRequest);
        return new BizResponse();
    }
}
