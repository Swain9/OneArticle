package com.maolin.basic.lambda;

import com.maolin.lambda.LambdaBean;
import com.maolin.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-07-04 09:25
 */
public class lambdaTest {

    private List<LambdaBean> list = new ArrayList<LambdaBean>() {
        {
            add(new LambdaBean("check1", "huawei", "model1", 100));
            add(new LambdaBean("check2", "zhongxing", "model2", 300));
            add(new LambdaBean("check3", "fenghuo", "model3", 400));
            add(new LambdaBean("check4", "fenghuo", null, 500));
            add(new LambdaBean("check4", "fenghuo", "model3", 600));
        }
    };

    @Test
    public void test0() {
        long a = 100L;
        int b = (int) a + 2;

        String ifName = "check4";
        String manufacturer = "fenghuo";
        List<LambdaBean> collect = list.stream()
                .filter(timeout -> timeout.getIfName().equals(ifName))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test1() {
        String ifName = "check4";
        String manufacturer = "fenghuo";
        String model = "model3";
        Optional<LambdaBean> first = list.stream()
                .filter(timeout -> timeout.getIfName().equals(ifName))
                .filter(timeout -> timeout.getManufacturer().equals(manufacturer))
                .filter(timeout -> {
                    if (StringUtils.isEmpty(model)) {
                        return true;
                    }
                    return model.equals(timeout.getModel());
                })
                .findFirst();
        if (first.isPresent()) {
            System.out.println(first.get().getTimeout());
        } else {
            System.out.println("不存在");
        }
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("你好，");
        list.add("我是张三, ");
        list.add(" 欢迎！");
        String reduce = list.stream().reduce("", (a, b) -> a + b);
        System.out.println(reduce);
    }

    @Test
    public void test3() {
        List<LambdaBean> collect1 = list.stream()
                .sorted(Comparator.comparing(LambdaBean::getTimeout, (Comparator.reverseOrder())))
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(collect1);

        List<LambdaBean> collect2 = list.stream()
                .sorted(Comparator.comparing(LambdaBean::getTimeout))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(collect2);
    }
}
