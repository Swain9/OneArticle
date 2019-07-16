package com.maolin.zerenlian.handle;

import com.maolin.zerenlian.model.BizRequest;

import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 11:37
 */
public class Test1ParamsHandleImpl extends BaseParamsHandle {
    /**
     * 处理参数
     *
     * @param request 请求对象
     */
    @Override
    public void process(BizRequest request) {
        Map<String, String> params = request.getParams();
        params.put("test1", "test1");
        next(request);
    }
}
