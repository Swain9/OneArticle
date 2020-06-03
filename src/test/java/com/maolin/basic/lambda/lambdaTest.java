package com.maolin.basic.lambda;

import com.maolin.entity.Product;
import com.maolin.lambda.LambdaBean;
import com.maolin.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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


    /**
     * https://blog.csdn.net/puppylpg/article/details/78556730
     */
    @Test
    public void test4() {
        List<Product> productList = new ArrayList<Product>() {
            {
                Product p1 = new Product();
                p1.setName("张三");

                Product p2 = new Product();
                p2.setName("李四");

                Product p3 = new Product();
                p3.setName("王五");

                Product p4 = new Product();
                p4.setPrice(100);
                p4.setName("张三");

                add(p4);
                add(p3);
                add(p2);
                add(p1);
            }
        };

        List<Product> distinct = productList.stream()
                .filter(distinctByKey(Product::getName))
                .collect(Collectors.toList());

        System.out.println(distinct);
    }

    /**
     * https://howtodoinjava.com/java8/java-stream-distinct-examples/
     * <p>
     * 1.使用put方法添加键值对，如果map集合中没有该key对应的值，则直接添加，并返回null，如果已经存在对应的值，则会覆盖旧值，value为新的值。
     * <p>
     * 2.使用putIfAbsent方法添加键值对，如果map集合中没有该key对应的值，则直接添加，并返回null，如果已经存在对应的值，则依旧为原来的值。
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Test
    public void test5() {
        List<Product> productList1 = new ArrayList<Product>() {
            {
                Product p1 = new Product();
                p1.setName("张三");

                Product p2 = new Product();
                p2.setName("李四");

                Product p3 = new Product();
                p3.setName("王五");

                Product p4 = new Product();
                p4.setPrice(100);
                p4.setName("张三");

                add(p4);
                add(p3);
                add(p2);
                add(p1);
            }
        };

        List<Product> productList2 = new ArrayList<Product>() {
            {
                Product p1 = new Product();
                p1.setName("张三");

                Product p2 = new Product();
                p2.setName("李四");

                Product p3 = new Product();
                p3.setName("王五");

                Product p4 = new Product();
                p4.setPrice(100);
                p4.setName("张三");

                add(p4);
                add(p3);
                add(p2);
                add(p1);
            }
        };

        List<Product> productList3 = new ArrayList<Product>() {
            {
                Product p1 = new Product();
                p1.setName("张三");

                Product p2 = new Product();
                p2.setName("李四");

                Product p3 = new Product();
                p3.setName("王五");

                Product p4 = new Product();
                p4.setPrice(100);
                p4.setName("张三");

                add(p4);
                add(p3);
                add(p2);
                add(p1);
            }
        };

        Map<String, List<Product>> map = new HashMap<>();
        map.merge("a", productList1, (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
        });
        map.merge("b", productList2, (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
        });
        map.merge("a", productList3, (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
        });
        System.out.println(map);
    }



    @Test
    public void arraysTest(){
        String a = "a";
        //Arrays.stream(a);
    }
}
