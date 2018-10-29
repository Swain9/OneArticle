package com.maolin.basic.util.regex;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */
public class PatternTest {

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
    public void testMatch4(){
        String value = "show ip bgp community exact-match no-advertise no-export exact-match \n" +
                "GPN710A>show ip bgp community exact-match no-advertise no";
        String s = value.substring(0, value.lastIndexOf(">")+1);
        System.out.println(s);
    }

    @Test
    public void testMatcher5(){
        String value = "GPN710A>";
        boolean matches = value.matches("\\S*[>#]");
        System.out.println(matches);
    }

}




