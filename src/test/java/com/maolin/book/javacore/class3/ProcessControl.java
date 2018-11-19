package com.maolin.book.javacore.class3;

import com.maolin.book.javacore.PrintUtil;
import org.junit.Test;

/**
 * <PRE>
 * 3.8 流程控制
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-19 10:22
 */
public class ProcessControl extends PrintUtil {

    /**
     * 3.8.1 块作用域（block）
     * <p>
     * 块（即复合语句）是指由一对大括号括起来的若干条简单的 Java 语句。块确定了变量的作
     * 用域。一个块可以嵌套在另一个块中
     */
    @Test
    public void test1() {
        int n = 0;
        {
            int k = 1;
            //int n = 2; 不能在嵌套的块中定义相同的变量
        }
        //无法访问k
        int k;
        print(n);
    }

    /**
     * 3.8.2 条件语句
     * 3.8.3 循 环
     * 3.8.4 确 定 循 环
     * 3.8.5 多重选择：switch 语句
     */
    @Test
    public void test2() {
        //if (condition) statement

        //使用块语句可以执行多条
        //if (condition) { statement1;statement2; }

        //if (condition) statement1 else statement2

        //如果开始循环条件的值就为 false, 则 while 循环体一次也不执行
        //while (condition) statement

        //至少执行一次再判断条件是否循环
        //do statement while (condition);

        //for 语句的第 1 部分通常用于对计数器初始化；第 2 部分给出每次新一轮循环执行前要检
        //测的循环条件；第 3 部分指示如何更新计数器。
        //for(init; check; update) { statement; }

        //switch语句将从与选项值相匹配的 case 标签处开始执行直到遇到 break 语句，或者执行到
        //switch 语句的结束处为止。如果没有相匹配的 case 标签， 而有 default 子句， 就执行这个子句
        //case 标签可以是：
        //•类型为 char、byte、 short 或 int 的常量表达式。
        //•枚举常量。
        //•从 Java SE 7开始， case 标签还可以是字符串字面量
    }

    /**
     * 3.8.6 中断控制流程语句
     */
    @Test
    public void test3() {
        int i = 0;
        boolean whileEnd = true;
        while (true) {
            breakWhile:
            {
                print("while中i的值：{0}", i);
                while (whileEnd) {
                    if (i < 20) {
                        i++;
                        break breakWhile;
                    } else {
                        whileEnd = false;
                    }
                }
                break;
            }
        }


        boolean ifEnd = true;
        breakIf:
        {
            print("if中判断的条件为：{0}", ifEnd);
            //ifEnd = false;
            if (ifEnd) {
                ifEnd = false;
                break breakIf;
            }
            print("只有当if为false的时候才会执行");
        }
        //if中使用break point的时候会跳转到这里来
        print("if中判断的条件为：{0}", ifEnd);

        int j = 0;
        while (true) {
            print("while中j的值：{0}", j);
            if (j > 10) {
                break;
            } else {
                j++;
                continue;
            }
        }
        //break
        //continue
        //return 特殊的中断
    }

}
