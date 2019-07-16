package com.maolin.zerenlian;

import com.maolin.zerenlian.controller.DemoController;
import com.maolin.zerenlian.model.BizRequest;
import com.maolin.zerenlian.model.BizResponse;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-15 17:46
 */
public class ZeRenLianTest {

    public static void main(String[] args) {
        DemoController controller = new DemoController();

        BizRequest request = new BizRequest();
        request.setBizId("biz001");
        request.setBizName("第一个业务");

        BizResponse bizResponse = controller.test1(request);
        System.out.println(bizResponse);
    }
}
