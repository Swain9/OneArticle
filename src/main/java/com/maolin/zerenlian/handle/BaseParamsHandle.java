package com.maolin.zerenlian.handle;

import com.maolin.zerenlian.model.BizRequest;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-15 17:49
 */
public abstract class BaseParamsHandle {

    protected BaseParamsHandle baseParamsHandle;

    public void setBaseParamsHandle(BaseParamsHandle baseParamsHandle) {
        this.baseParamsHandle = baseParamsHandle;
    }

    /**
     * 处理参数
     *
     * @param request 请求对象
     */
    public abstract void process(BizRequest request);

    protected void next(BizRequest request) {
        if (baseParamsHandle != null) {
            baseParamsHandle.process(request);
        }
    }
}
