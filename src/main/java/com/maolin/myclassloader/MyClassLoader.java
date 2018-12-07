package com.maolin.myclassloader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-12-07 14:23
 */
public class MyClassLoader {

    public static void main(String[] args) throws MalformedURLException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        //test1();
        //test2();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println("是否继续？");
            String next = scanner.next();
            if (!"y".equalsIgnoreCase(next)) {
                break;
            }
            test3("LoadUserPrint");
        }
    }

    private static void test3(String className) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        //指定class文件目录
        URL classUrl = new URL("file:/E:/kidspace/learn_article/classloader/");
        //创建一个新的类加载器，并且给它指定一个目录
        URLClassLoader loader = new URLClassLoader(new URL[]{classUrl});
        Class<?> clazz = loader.loadClass("com.maolin.myclassloader." + className);
        IUserPrint obj = (IUserPrint) clazz.newInstance();
        obj.print();
    }

    private static void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = MyClassLoader.class.getClassLoader();
        Class<?> clazz = classLoader.loadClass("com.maolin.myclassloader.BaseUserPrint");
        Object obj = clazz.newInstance();
        Object print = clazz.getMethod("print").invoke(obj);
        System.out.println("反射执行的方法返回值为：" + print);
    }

    private static void test1() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL resource = MyClassLoader.class.getResource("/");
        System.out.println(resource);

        //指定class文件目录
        URL classUrl = new URL("file:/E:/kidspace/learn_article/target/classes/");
        //创建一个新的类加载器，并且给它指定一个目录
        URLClassLoader loader = new URLClassLoader(new URL[]{classUrl});
        //通过类加载器进行加载，如果有包名，加上
        Class<?> clazz = loader.loadClass("com.maolin.myclassloader.BaseUserPrint");
        //构建一个实例对象
        IUserPrint print = (IUserPrint) clazz.newInstance();
        //调用方法
        print.print();
        loader.close();
    }

}
