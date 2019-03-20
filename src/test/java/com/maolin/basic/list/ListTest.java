package com.maolin.basic.list;

import com.maolin.entity.PwInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author zhangmaolin
 * @date 2018-09-20 19:52
 * @since 0.0.1
 */
public class ListTest {

    @Test
    public void testNull(){
        ListTest listTest = new ListTest();
        List<String> list = listTest.getList();
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testListForEach() {
        List<String> list = getList();
        for (String s : list) {
            System.out.println(s);
        }
    }
    @Test
    public void testSet(){
        Set<String> set = new HashSet<>();
        set.add("你好");
        set.add("zhangmaol");
        System.out.println(set);
    }

    private List<String> getList() {
        return null;
    }

    @Test
    public void removeDuplicate() {
        List<PwInfo> list1 = new ArrayList<PwInfo>() {{
            add(new PwInfo("111", "222"));
            add(new PwInfo("333", "444"));
            add(new PwInfo("555", "666"));
            add(new PwInfo("777", "888"));
            add(new PwInfo("999", "000"));
        }};
        List<PwInfo> list2 = new ArrayList<PwInfo>() {{
            add(new PwInfo("777", "888"));
            add(new PwInfo("000", "999"));
            add(new PwInfo("aaa", "zzz"));
        }};
        List<PwInfo> list3 = new ArrayList<>();

        /*for (PwInfo pw1 : list1) {
            for (PwInfo pw2 : list2) {
                if (check(pw1, pw2)) {
                    continue;
                }
                list3.add(pw2);
            }
        }*/
        //正确写法1：
        /*for (int i = list2.size() - 1; i >= 0; i--) {
            PwInfo pw2 = list2.get(i);
            boolean flag = true;
            for (PwInfo pw1 : list1) {
                if (check(pw1, pw2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list3.add(pw2);
                list2.remove(pw2);
            }
        }
        list1.addAll(list3);*/

        for (PwInfo pw2 : list2) {
            boolean flag = true;
            for (PwInfo pw1 : list1) {
                if (check(pw1, pw2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list3.add(pw2);
            }
        }
        list1.addAll(list3);
        System.out.println(list1);

    }

    private boolean check(PwInfo pw1, PwInfo pw2) {
        if (pw1.getApw().equals(pw2.getApw()) && pw1.getZpw().equals(pw2.getZpw())) {
            return true;
        }
        if (pw1.getApw().equals(pw2.getZpw()) && pw1.getZpw().equals(pw2.getApw())) {
            return true;
        }
        return false;
    }

    @Test
    public void listaddnull(){
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

    @Test
    public void testList(){
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        //a.add("d");
        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("b");
        b.add("c");
        b.add("d");
//        List<String> strings = filterPost(a, b);
//        System.out.println(strings);
        boolean b1 = b.removeAll(a);
        System.out.println(b);
    }


    public List<String> filterPost(List<String> compareList, List<String> saveList) {

        if (compareList == null || compareList.size() == 0) {

            return saveList;
        }
        Iterator<String> iterator = saveList.iterator();
        while (iterator.hasNext()) {

            String port = iterator.next();
            for (String port2 : compareList) {

                if (port.equals(port2)) {

                    iterator.remove();
                    break;
                }
            }
        }
        return saveList;
    }

    @Test
    public void testContais(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int z = 0;
        for (int i = 1; i <= 5; i++) {
            if (list.contains(i)) {
                continue;
            }
            z = i;
            System.out.println(i);
            break;
        }
        System.out.println(z);
    }
}
