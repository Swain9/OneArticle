package com.maolin.basic.pattern;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */
public class PatternTest2 {

    @Test
    public void testMatch() {
        String s = "id:1;name:zhangmaolin;";
        String reg = "id:(?<id>\\d+);name:(?<name>\\D+);";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(s);
        //matches：全部匹配
        if (matcher.matches()) {
            String id = matcher.group("id");
            String name = matcher.group("name");
            System.out.printf("id:%s;name:%s", id, name);
        }
    }

    @Test
    public void testMatcher() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        //find：部分匹配
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void testMatch2() {
        String a = "                route-policy          default-parameter     \n" +
                "\n" +
                "tunnel-policy         \n" +
                "\n" +
                "IPA500>show ";
        //String ma = "(.*)>show(\\s*)";
        //String ma = "([\\s\\S]*)>show(\\s*)";
        String ma = "([\\s\\S]*)>show([\\s\\S]*)";
        boolean matches = a.matches(ma);
        System.out.println(matches);
    }

    @Test
    public void testMatch3() {
        String a = "show ccc \n" +
                "\n" +
                "IPA500>show ccc brief ";
        String reg = "([\\s\\S]*)>show([\\s\\S]*)";
        boolean matches = a.matches(reg);
        System.out.println(matches);
    }

    @Test
    public void testSpilit() {
        String value = "show \n" +
                "\n" +
                "bfd                   bgp                   ccc                   \n" +
                "\n" +
                "mpls                  tunnel                tunnel-info           \n" +
                "\n" +
                "eth-trunk             brg-trunk             rou-trunk             \n" +
                "\n" +
                "acl                   alarm                 arp                   \n" +
                "\n" +
                "boot-loader           cfm                   clock                 \n" +
                "\n" +
                "cpu-usage             current-configuration dcn                   \n" +
                "\n" +
                "debug                 device                dhcp                  \n" +
                "\n" +
                "diffserv-domain       domain                elps                  \n" +
                "\n" +
                "environment           fan                   fib                   \n" +
                "\n" +
                "flow                  global-debug-cmd      history-command       \n" +
                "\n" +
                "igmp                  interface             ip                    \n" +
                "\n" +
                "lldp                  logbuffer             loopback-detection    \n" +
                "\n" +
                "mac-address           mc-pw                 memory-usage          \n" +
                "\n" +
                "mirroring-group       mspr                  multicast             \n" +
                "\n" +
                "nas                   ntp-service           oam                   \n" +
                "\n" +
                "pim                   port                  port-qos              \n" +
                "\n" +
                "port-utilization      prbs                  pw-aps                \n" +
                "\n" +
                "qos-policy            rmon                  saved-configuration   \n" +
                "\n" +
                "section               slamon                snmp-agent            \n" +
                "\n" +
                "synce                 synchroniz            system-mac            \n" +
                "\n" +
                "transceiver           trapbuffer            user                  \n" +
                "\n" +
                "v-uni                 version               vlan                  \n" +
                "\n" +
                "vsi                   route-policy          default-parameter     \n" +
                "\n" +
                "tunnel-policy         \n" +
                "\n" +
                "IPA500>show";

        String s = value.replaceAll("[\\s]+", ",");
        System.out.println(s);
        String[] cmds = s.split(",");
        System.out.println(cmds.length);
        Set<String> cmdSet = new HashSet<>();
        for (String cmd : cmds) {
            if (!cmd.contains("show")) {
                cmdSet.add(cmd);
            }
            System.out.println(cmd);
        }

        cmdSet.forEach(System.out::print);
    }

    @Test
    public void testMatch4() {
        String value = "show ip bgp community exact-match no-advertise no-export exact-match \n" +
                "GPN710A>show ip bgp community exact-match no-advertise no";
        String s = value.substring(0, value.lastIndexOf(">") + 1);
        System.out.println(s);
        String ss = "show ip bgp community exact-match no-advertise";
        int i = value.lastIndexOf(">");
        System.out.println(i);
        int length = ss.length();
        System.out.println("ss.length:" + length);
        String substring1 = value.substring(i + 1);
        System.out.println(substring1.length());
        System.out.println(substring1);
        System.out.println(value.length());
        String substring = value.substring(i + 1, i + length + 1);
        System.out.println(substring);
    }

    @Test
    public void testReplace() {
        String value = "nihao value value nihao nihao value";
        String nihao = value.replace("nihao", "");
        System.out.println(nihao);
    }

    @Test
    public void testMatcher5() {
        String value = "GPN710A>";
        boolean matches = value.matches("\\S*[>#]");
        System.out.println(matches);
    }

    @Test
    public void testMatcher6() {
        String value = "张三1990-01-10,20岁";
        Pattern pattern = Pattern.compile("(\\S*)((\\d{4})-(\\d{2})-(\\d{2})),(\\d*)岁");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            System.out.println(matcher.group(5));
            System.out.println(matcher.group(6));
            System.out.println(matcher.group(7));
        }
    }

    /**
     * 正则查找
     */
    @Test
    public void testMatcher7() {
        String value = "张三1990-01-10,20岁";
        Pattern pattern = Pattern.compile("((\\d{4})-(\\d{2})-(\\d{2}))");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            //System.out.println(matcher.group(5));
        }
        if (matcher.matches()) {
            System.out.println("匹配到了");
        }
    }

    /**
     * https://blog.csdn.net/thewindkee/article/details/52785763
     */
    @Test
    public void testMatcher8() {
        String value = "CX600-D8";
        value = "CX600-M8";
        //Pattern pattern = Pattern.compile("(?i)^(CX600)((?!-M8).*)$");
        Pattern pattern = Pattern.compile("(?i)^(CX600)((?!-M8).)*$");
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            System.out.println("匹配到了");
        }
    }

    @Test
    public void testMatcher9() {
        String value = "张三 18 2018-10-01\n李四 22 2010-11-11\n王五 88 2000-01-02\nEnd   time: 2018-02-06 18:46:57";
//        String value = "张三 18 2018-10-01\n李四 22 2010-11-11\n王五 88 2000-01-02\n   End   time: --";
        Pattern pattern = Pattern.compile("([\\u4e00-\\u9fa5]+) (\\d+) (\\d{4}-\\d{1,2}-\\d{1,2})");
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            System.out.print("姓名：" + matcher.group(1));
            System.out.print("，年龄：" + matcher.group(2));
            System.out.print("，注册时间：" + matcher.group(3));
            System.out.println("");
        }
        Pattern endTime = Pattern.compile("(?i)End\\s+time:\\s+--");
        Matcher endMacher = endTime.matcher(value);
        if (endMacher.find()) {
            System.out.println("未完成");
        } else {
            System.out.println("已完成");
        }
    }

    private Pattern areaIdPat = Pattern.compile("^\\d*$");

    @Test
    public void testMatcher10() {
        String a = "323";
        String b = "a32";
        if (a.matches("\\d*")) {
            System.out.println(a);
        }
        if (b.matches("\\d*")) {
            System.out.println(b);
        }
        System.out.println("=");
        if (areaIdPat.matcher(a).matches()) {
            System.out.println(a);
        }
        if (areaIdPat.matcher(b).matches()) {
            System.out.println(b);
        }
    }


    /**
     * 中文 正则 校验
     */
    @Test
    public void testMatcher11() {
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        String a = "张三你好sadfjij";
        a = "asdf-jdjj漷jj";
        String b = "R032-YouDianTongXinDong";


        Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            System.out.println(a);
        }

        Matcher matcher1 = pattern.matcher(b);
        if (!matcher1.find()) {
            System.out.println(b);
        }
    }

    /**
     * 在使用正则表达式的时候，我们经常会使用()把某个部分括起来，称为一个子模式。
     * 子模式有Capturing和Non-Capturing两种情况。
     * Capturing指获取匹配 ，是指系统会在幕后将所有的子模式匹配结果保存起来，供我们查找或者替换。如后向引用的使用；
     * 而Non-Capturing指非获取匹配 ，这时系统并不会保存子模式的匹配结果，子模式的匹配更多的只是作为一种限制条件使用，如正向预查，反向预查，负正向预查，负反向预查等。
     * https://www.jianshu.com/p/8bf162425d83
     */
    @Test
    public void test13() {
        String loopbackIp = null;
        Pattern loopbackPortPat = Pattern.compile("(?i)^loopback");
        Pattern loopbackPortPat2 = Pattern.compile("Loop\\S+");
        Map<String, String> treeMap = new TreeMap<>();
        String name = "dloopback1023";

        Matcher matcher = loopbackPortPat.matcher(name);
        if (matcher.find()) {
            System.out.println(name);
        }else{
            matcher = loopbackPortPat2.matcher(name);
            if (matcher.find()) {
                System.out.println(name);
            }
        }
    }
    private static final Pattern portPat = Pattern.compile("(\\S+)\\(\\S+\\)");
    @Test
    public void test14(){
        String name = "GigabitEthernet1/0/25";
        Matcher matcher = portPat.matcher(name);
        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
        }
    }
}




