package com.maolin.basic.string;

import org.junit.Test;

public class MaskTest {

    /**
     * Mask 点十进制转short
     */
    @Test
    public void testMask2Short() {
        StringBuilder sbf;
        String str;
        String strip = "255.255.255.254";   //子网掩码
        int inetmask = 0, count = 0;       //子网掩码缩写代码
        String[] ipList = strip.split("\\.");
        for (int n = 0; n < ipList.length; n++) {

            sbf = toBin(Integer.parseInt(ipList[n]));
            str = sbf.reverse().toString();
            System.out.println(ipList[n] + "---" + str);

            //统计2进制字符串中1的个数
            count = 0;
            for (int i = 0; i < str.length(); i++) {
                i = str.indexOf('1', i);  //查找 字符'1'出现的位置
                if (i == -1) {
                    break;
                }
                count++;  //统计字符出现次数
            }
            inetmask += count;

        }
        System.out.println("子网掩码缩写代码：" + inetmask);
    }

    private StringBuilder toBin(int x) {
        StringBuilder result = new StringBuilder();
        result.append(x % 2);
        x /= 2;
        while (x > 0) {
            result.append(x % 2);
            x /= 2;
        }
        return result;
    }
}
