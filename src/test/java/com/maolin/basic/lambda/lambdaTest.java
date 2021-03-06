package com.maolin.basic.lambda;

import com.maolin.entity.Product;
import com.maolin.lambda.LambdaBean;
import com.maolin.util.StringUtils;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
    public void arraysTest() {
        String a = "a";
        //Arrays.stream(a);
    }


    @Test
    public void test() {

        UserInfo u1 = new UserInfo();
        u1.setId("1");
        u1.setName("张三");

        UserInfo u2 = new UserInfo();
        u2.setId("2");
        u2.setName("李四");

        UserInfo u3 = new UserInfo();
        u3.setId("3");
        u3.setName("王五");

        UserInfo u4 = new UserInfo();
        u4.setId("4");
        u4.setName("刘麻子");

        UserDetail d1 = new UserDetail();
        d1.setId("1");
        d1.setNum("20");

        UserDetail d2 = new UserDetail();
        d2.setId("2");
        d2.setNum("20");

        UserDetail d3 = new UserDetail();
        d3.setId("3");
        d3.setNum("30");

        UserDetail d4 = new UserDetail();
        d4.setId("4");
        d4.setNum("30");

        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(u1);
        userInfoList.add(u2);
        userInfoList.add(u3);
        userInfoList.add(u4);

        List<UserDetail> userDetailList = new ArrayList<>();
        userDetailList.add(d1);
        userDetailList.add(d2);
        userDetailList.add(d3);
        userDetailList.add(d4);

        Map<String, List<UserInfo>> collect = userInfoList.stream()
                .collect(Collectors.groupingBy(userInfo -> {
                    String uid = userInfo.getId();
                    return userDetailList.stream().filter(userDetail -> {
                        String did = userDetail.getId();
                        return uid.equals(did);
                    }).findFirst().get().getNum();
                }));
        System.out.println(collect);
    }

    @Test
    public void testSort(){
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("3");
        s1.add("5");
        s1.add("6");
        Set<String> s2 = new HashSet<>();
        s2.add("2");
        s2.add("4");
        s2.add("6");
        s2.add("8");
        Set<String> s3 = new HashSet<>();
        s3.add("11");
        Set<String> s4 = new HashSet<>();
        s4.add("12");
        s4.add("22");
        Set<String> s5 = new HashSet<>();
        s5.add("13");
        s5.add("23");
        s5.add("33");
        List<Set<String>> setList = new ArrayList<>();
        setList.add(s1);
        setList.add(s2);
        setList.add(s3);
        setList.add(s4);
        setList.add(s5);

        List<Set<String>> collect = setList.stream()
                .sorted((o1, o2) -> {
                    if (o1.size() == o2.size()) {

                        String o1Min = o1.stream().sorted().findFirst().orElse("0");
                        String o2Min = o2.stream().sorted().findFirst().orElse("0");
                        return Integer.parseInt(o1Min) - Integer.parseInt(o2Min);
                    }
                    return o1.size() - o2.size();
                }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testNull(){
        List<String> a = new ArrayList<>();
        String collect = a.stream().map(s -> s)
                .collect(Collectors.joining(";"));
        System.out.println(collect);
        List<String> b = a.stream().map(s -> s)
                .collect(Collectors.toList());
        System.out.println(String.join(",", b));
    }

    @Test
    public void testMerge(){
        String s = "nihao";
        Map<String, Integer> countMap = new HashMap<>();

        //countMap.put(s, 1);

        Integer count = countMap.merge(s, 1, Integer::sum);
        System.out.println(count);
        count = countMap.merge(s, 1, Integer::sum);
        System.out.println(count);
        count = countMap.merge(s, 1, Integer::sum);
        System.out.println(count);
    }

}

@Data
class UserInfo {
    private String id;
    private String name;
}

@Data
class UserDetail {
    private String id;
    private String num;
}