package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.PrintUtil;
import org.junit.Test;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

/**
 * 3.7 输入输出
 *
 * @author zhangmaolin
 * @date 2018-11-18 15:46
 * @since 0.0.1
 */
public class InputOutput extends PrintUtil {

    /**
     * 3.7.1 读取输入
     */
    @Test
    public void test1() {
        //打印输出到“标准输出流（即控制台窗口）”，只要调用System.out.println
        //读取“标准输入流” System.in就没有那么简单了

        //1，构造Scanner对象
        Scanner in = new Scanner(System.in);
        //2, 调用Scanner类的方法实现输入
        print("你的名字是什么？");
        //此处无法实现，因为junit是单元测试，自动测试，不支持人工从控制台输入，需要使用main方法
        String name = in.nextLine(); //获取一行
        print(name);
        print("你的名字是什么？");
        String firstName = in.next();//读取第一个单词（空白符隔开的第一个连续字符串）
        print(firstName);
        print("你多大了？");
        int age = in.nextInt();//读取下一个整数
        print(age);
    }

    @Test
    public void test1_1() {
        //因为输入是可见的， 所以 Scanner 类不适用于从控制台读取密码。Java SE 6 特别
        //引入了 Console 类实现这个目的。要想读取一个密码， 可以采用下列代码
        Console console = System.console(); //无法在ide工具中使用，原因是该代码关联cmd
        String name = console.readLine("你的名字是：");
        char[] password = console.readPassword("你的密码是：{1}", 123456);
    }

    public static void main(String[] args) {
        InputOutput output = new InputOutput();
        //output.test1();
        output.test1_1();
    }

    /**
     * 3.7.2 格式化输出
     */
    @Test
    public void test2() {
        double x = 10000.0 / 3.0;
        print(x);

        //用 8 个字符的宽度和小数点后两个字符的精度打印 x。
        //即 3333.33  空格3333.33共八个字符
        System.out.printf("%8.2f", x);
        print("");
        //每一个以 % 字符开始的格式说明符都用相应的参数替换。 格式说明符尾部的转换符将指示被
        //格式化的数值类型：f 表示浮点数，s 表示字符串，d 表示十进制整数。表 3.7.2 列出了所有转换符

        //还可以给出控制格式化输出的各种标志
        printf("%,2f", x);

        //可以使用 s 转换符格式化任意的对象,， 对于任意实现了 Formattable 接口的对象都
        //将调用 formatTo 方法；否则将调用 toString 方法， 它可以将对象转换为字符串。
        ObjectFormatter objectFormatter = new ObjectFormatter();
        objectFormatter.setName("张三");
        objectFormatter.setAge(11);
        printf("%s", objectFormatter);

        String message = String.format("Hello, %s. Next year, you'll be %d", objectFormatter.getName(), objectFormatter.getAge());
        print(message);

        //日期
        Date date = new Date();
        printf("%tc", date);
        printf("%tY", date);
        printf("%tm", date);
        printf("%td", date);
        printf("%tH", date);
        printf("%tM", date);
        printf("%tS", date);

        //上面只能获取参数的一部分，而且太蠢了
        //%1$，表示params参数中，格式化的第一个参数
        //%2$，表示params参数中，格式化的第二个参数
        //可以对同一个参数进行多次处理
        printf("%1$s %2$tY-%2$tm-%2$td %2$tH:%2$tM:%2$tS", "当前日期为：", date); //参数索引是从1开始
        //还可以选择使用 < 标志它指示前而格式说明中的参数将被再次被使用，也就是说， 下列
        //语句将产生与前面语句同样的输出结果：
        printf("%s %tY-%<tm-%<td %<tH:%<tM:%<tS", "当前日期为：", date);

    }

    /**
     * 3.7.3 文件输入与输出
     *
     */
    @Test
    public void test3() throws IOException, URISyntaxException {
        //如果文件名中包含反斜杠符号，就要记住在每个反斜杠之前再加一个额外的反斜杠：
        //“ c:\\mydirectory\\myfile.txt ” c
        Path path = Paths.get("src/test/resources/myfile.txt");
        //用 File或者Path 对象构造一个 Scanner 对象
        Scanner in = new Scanner(path, "UTF-8");
        while (in.hasNext()) {
            String line = in.nextLine();
            print(line);
        }
        in.close();

        PrintWriter out = new PrintWriter("src/test/resources/myfile.txt", "UTF-8");
        out.print("你好,,");
        out.println();
        out.println("卧室,,");
        out.flush();
        out.write("厉害了");
        out.close();

        //当指定一个相对文件名时， 例如，“ myfile.txt”，“ mydirectory/myfile.txt” 或“ ../myfile.txt ”
        //文件位于 Java 虚拟机启动路径的相对位置 ，

        //如果在命令行方式下用下列命令启动程序 ： java MyProg

        //启动路径就是命令解释器的当前路径。 然而，如果使用集成开发环境， 那么启动路
        //径将由 IDE 控制。 可以使用下面的调用方式找到路径的位置
        String property = System.getProperty("user.dir");
        print(property);

        //当采用命令行方式启动一个程序时， 可以利用 Shell 的重定向语法将任意文件关联
        //到 System.in 和 System.out: ,这样，就不必担心处理 IOException 异常了。

        //java MyProg < myfile.txt > output.txt
    }


}
