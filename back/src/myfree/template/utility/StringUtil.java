package com.maolin.myfree.template.utility;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-27 10:13
 */
public class StringUtil {
    public static String jQuote(String s) {
        if (s == null) {
            return "null";
        }
        int ln = s.length();
        StringBuilder b = new StringBuilder(ln + 4);
        b.append('"');
        for (int i = 0; i < ln; i++) {
            char c = s.charAt(i);
            if (c == '"') {
                b.append("\\\"");
            } else if (c == '\\') {
                b.append("\\\\");
            } else if (c < 0x20) {
                if (c == '\n') {
                    b.append("\\n");
                } else if (c == '\r') {
                    b.append("\\r");
                } else if (c == '\f') {
                    b.append("\\f");
                } else if (c == '\b') {
                    b.append("\\b");
                } else if (c == '\t') {
                    b.append("\\t");
                } else {
                    b.append("\\u00");
                    int x = c / 0x10;
                    b.append(toHexDigit(x));
                    x = c & 0xF;
                    b.append(toHexDigit(x));
                }
            } else {
                b.append(c);
            }
        } // for each characters
        b.append('"');
        return b.toString();
    }
    private static char toHexDigit(int d) {
        return (char) (d < 0xA ? d + '0' : d - 0xA + 'A');
    }
}
