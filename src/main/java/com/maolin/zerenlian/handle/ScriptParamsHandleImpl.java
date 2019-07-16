package com.maolin.zerenlian.handle;

import com.maolin.zerenlian.model.BizRequest;

import java.util.Map;

/**
 * <PRE>
 * 脚本参数处理对象
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-16 09:21
 */
public class ScriptParamsHandleImpl extends BaseParamsHandle {
    /**
     * 处理参数
     *
     * @param request 请求对象
     */
    @Override
    public void process(BizRequest request) {
        Map<String, String> params = request.getParams();
        params.put("ASG", "ASG1");
        params.put("CSG", "CSG1");
        next(request);
    }
}
