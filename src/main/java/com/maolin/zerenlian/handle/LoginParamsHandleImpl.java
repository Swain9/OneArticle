package com.maolin.zerenlian.handle;

import com.maolin.zerenlian.model.BizRequest;

import java.util.Map;

/**
 * <PRE>
 * 设备登陆处理参数对象
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:20
 */
public class LoginParamsHandleImpl extends BaseParamsHandle {
    /**
     * 处理参数
     *
     * @param request 请求对象
     */
    @Override
    public void process(BizRequest request) {
        Map<String, String> params = request.getParams();
        params.put("username", "admin");
        params.put("password", "123456");
        next(request);
    }
}
