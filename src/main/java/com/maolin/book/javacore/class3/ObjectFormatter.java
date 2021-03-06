package com.maolin.book.javacore.class3;

import java.util.Formattable;
import java.util.Formatter;

/**
 * @author zhangmaolin
 * @date 2018-11-18 18:23
 * @since 0.0.1
 */
public class ObjectFormatter implements Formattable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Formats the object using the provided {@link Formatter formatter}.
     *
     * @param formatter The {@link Formatter formatter}.  Implementing classes may call
     *                  {@link Formatter#out() formatter.out()} or {@link
     *                  Formatter#locale() formatter.locale()} to obtain the {@link
     *                  Appendable} or {@link Locale} used by this
     *                  <tt>formatter</tt> respectively.
     * @param flags     The flags modify the output format.  The value is interpreted as
     *                  a bitmask.  Any combination of the following flags may be set:
     *                  {@link FormattableFlags#LEFT_JUSTIFY}, {@link
     *                  FormattableFlags#UPPERCASE}, and {@link
     *                  FormattableFlags#ALTERNATE}.  If no flags are set, the default
     *                  formatting of the implementing class will apply.
     * @param width     The minimum number of characters to be written to the output.
     *                  If the length of the converted value is less than the
     *                  <tt>width</tt> then the output will be padded by
     *                  <tt>'&nbsp;&nbsp;'</tt> until the total number of characters
     *                  equals width.  The padding is at the beginning by default.  If
     *                  the {@link FormattableFlags#LEFT_JUSTIFY} flag is set then the
     *                  padding will be at the end.  If <tt>width</tt> is <tt>-1</tt>
     *                  then there is no minimum.
     * @param precision The maximum number of characters to be written to the output.
     *                  The precision is applied before the width, thus the output will
     *                  be truncated to <tt>precision</tt> characters even if the
     *                  <tt>width</tt> is greater than the <tt>precision</tt>.  If
     *                  <tt>precision</tt> is <tt>-1</tt> then there is no explicit
     *                  limit on the number of characters.
     * @throws IllegalFormatException If any of the parameters are invalid.  For specification of all
     *                                possible formatting errors, see the <a
     *                                href="../util/Formatter.html#detail">Details</a> section of the
     *                                formatter class specification.
     */
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("我的名字是%s，年龄是%d", this.name, this.age);
    }
}
