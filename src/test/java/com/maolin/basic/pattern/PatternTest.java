package com.maolin.basic.pattern;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangmaolin
 * @version 0.0.1
 * @since 2018-08-23 16:31
 */
public class PatternTest {

    @Test
    public void testPattern() {
        String s = "(\\d+)([G|M])";
        Pattern pattern = Pattern.compile(s);
        String test = "1213123G";
        Matcher matcher = pattern.matcher(test);

        if (matcher.find()) {
            String all = matcher.group(0);
            String speed = matcher.group(1);
            String type = matcher.group(2);
            System.out.println(speed + ":" + type);
        }
    }

    @Test
    public void testFistAndEnd() {
        String value = "<DL><p><tab>你好</tab>" +
                "<DL><p><tab>我好</tab></DL><p>" +
                "<DL><p><tab>他好</tab></DL><p>" +
                "</DL><p>";
        String reg = "<DL><p>([\\s\\S]+)</DL><p>";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            String ss = matcher.group(1);
            System.out.println(ss);
        }
    }

    @Test
    public void repalceP() throws IOException {
        Path path = Paths.get("html.txt");
        InputStream inputStream = Files.newInputStream(path);
        StringBuilder builder = new StringBuilder();

        byte[] cache = new byte[1024];
        int index;
        while ((index = inputStream.read(cache)) != -1) {
            builder.append(new String(cache, 0, index));
        }
        String values = builder.toString();

        String valueReplaceP = values.replaceAll("<p>\\s*</p>", "");

        Path cacheFile = Paths.get("html_no_p.txt");
        boolean exists = Files.exists(cacheFile);
        if (!exists) {
            Files.createFile(cacheFile);
        }
        BufferedWriter bufferedWriter = Files.newBufferedWriter(cacheFile);
        bufferedWriter.write(valueReplaceP);
        bufferedWriter.close();
    }


    @Test
    public void testMatcher() throws IOException {
        Path path = Paths.get("D:/zml_down/bookmarks_2018_10_28.html");
        BufferedReader reader = Files.newBufferedReader(path);
        StringBuilder builder = new StringBuilder();
        String cache;
        while ((cache = reader.readLine()) != null) {
            builder.append(cache);
        }
        reader.close();
        String reg = "<DL><p>([\\s\\S]+)</DL><p>";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(builder.toString());
        if (matcher.find()) {
            String ss = matcher.group(1);
            Path cacheFile = Paths.get("cache.txt");
            boolean exists = Files.exists(cacheFile);
            if (!exists) {
                Files.createFile(cacheFile);
            }
            BufferedWriter bufferedWriter = Files.newBufferedWriter(cacheFile);
            bufferedWriter.write(ss);
            bufferedWriter.close();
        }
       /* PathEntity entity = new PathEntity();
        test(builder.toString(), entity);*/
    }

    @Test
    public void testReplace(){
        String s = "$name$, 你好";
        String replace = s.replace("$name$", "张三");
        String replace2 = s.replace("$name$", null);
        System.out.println(replace);
        System.out.println(replace2);
    }

    private static final Pattern huanPat = Pattern.compile("[(（]+(\\S+)[）)]+");
    private static final Pattern huanNamePat = Pattern.compile("[A-Za-z0-9]+");

    @Test
    public void test2(){
        String name = "JZ-龙川黄石-ATN950B-龙川UH（龙川1007链）";
        name = "JZ-街口蓝田(二)-从化UH（R1450环)";
        name = "(";
        int start1 = name.lastIndexOf("(");
        int start2 = name.lastIndexOf("（");
        int start = Math.max(start1, start2);
        String subName = name.substring(start);

        Matcher matcher = huanPat.matcher(subName);
        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);

            Matcher matcher1 = huanNamePat.matcher(group);
            if (matcher1.find()) {
                String group1 = matcher1.group();
                System.out.println(group1);
            }
        }
    }

}
