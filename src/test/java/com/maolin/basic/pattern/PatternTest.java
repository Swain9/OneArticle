package com.maolin.basic.pattern;

import com.google.common.collect.Lists;
import com.maolin.entity.PathEntity;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
    public void testBookMarker() throws IOException {
        Path path = Paths.get("D:/zml_down/bookmarks_2018_10_28.html");
        BufferedReader reader = Files.newBufferedReader(path);

        PathEntity parent = new PathEntity();
        parent.setId(0);
        parent.setName("");
        parent.setCreateDate("");
        parent.setUpdateDate("");
        parent.setFolder(false);
        parent.setHref("");
        parent.setIcon("");
        parent.setParent(new PathEntity());
        parent.setChilds(Lists.newArrayList());

        //test(reader, parent);
        testNotRecursive(reader, parent);
        reader.close();
        System.out.println(parent.toString());
    }

    private String h3NameReg = "<H3[\\s\\S]*>([\\s\\S]*)</H3>";
    private Pattern h3Name = Pattern.compile(h3NameReg);

    private String aNameReg = "<A[\\s\\S]*>([\\s\\S]*)</A>";
    private Pattern aName = Pattern.compile(aNameReg);

    private String createReg = "ADD_DATE=\"(\\S*)\"";
    private Pattern create = Pattern.compile(createReg);

    private String updateReg = "LAST_MODIFIED=\"(\\S*)\"";
    private Pattern update = Pattern.compile(updateReg);

    private String folderReg = "PERSONAL_TOOLBAR_FOLDER=\"(\\S*)\"";
    private Pattern folder = Pattern.compile(folderReg);

    private String hrefReg = "HREF=\"(\\S*)\"";
    private Pattern href = Pattern.compile(hrefReg);

    private String iconReg = "ICON=\"(\\S*)\"";
    private Pattern icon = Pattern.compile(iconReg);

    private int i = 0;

    private void testNotRecursive(BufferedReader reader, PathEntity parent) throws IOException {
        PathEntity lastPath = new PathEntity();
        lastPath = parent;
        String value;
        while ((value = reader.readLine()) != null) {
            if (value.contains("<DL>")) {

            } else if (value.contains("<DT><H3")) {
                PathEntity holder = new PathEntity();

                holder.setId(++i);
                holder.setName(matchValue(h3Name, value));
                holder.setCreateDate(matchValue(create, value));
                holder.setUpdateDate(matchValue(update, value));
                holder.setFolder(true);
                holder.setHref("");
                holder.setIcon("");
                holder.setChilds(Lists.newArrayList());
                holder.setParent(lastPath);
                lastPath.getChilds().add(holder);

                lastPath = holder;

            } else if (value.contains("<DT><A")) {
                PathEntity link = new PathEntity();
                link.setId(++i);
                link.setName(matchValue(aName, value));
                link.setCreateDate(matchValue(create, value));
                link.setUpdateDate(matchValue(update, value));
                link.setFolder(false);
                link.setHref(matchValue(href, value));
                link.setIcon(matchValue(icon, value));
                link.setChilds(Lists.newArrayList());
                link.setParent(lastPath);

                lastPath.getChilds().add(link);

            } else if (value.contains("</DL>")) {
                lastPath = lastPath.getParent();
            }
        }
    }

    private void test(BufferedReader reader, PathEntity parent) throws IOException {
        String value = reader.readLine();
        if (value == null) {
            return;
        }
        if (value.contains("<DL>")) {
            test(reader, parent);
        } else if (value.contains("<DT><H3")) {
            PathEntity holder = new PathEntity();

            holder.setId(++i);
            holder.setName(matchValue(h3Name, value));
            holder.setCreateDate(matchValue(create, value));
            holder.setUpdateDate(matchValue(update, value));
            holder.setFolder(true);
            holder.setParent(parent);
            List<PathEntity> list = new ArrayList<>();
            list.add(holder);
            parent.setChilds(list);

            test(reader, holder);

        } else if (value.contains("<DT><A")) {
            PathEntity link = new PathEntity();
            link.setId(++i);
            link.setName(matchValue(aName, value));
            link.setCreateDate(matchValue(create, value));
            link.setUpdateDate(matchValue(update, value));
            link.setFolder(false);
            link.setHref(matchValue(href, value));
            link.setIcon(matchValue(icon, value));
            link.setParent(parent);
            link.setChilds(null);

            test(reader, parent);
        } else if (value.contains("</DL>")) {
            test(reader, parent.getParent());
        }
        test(reader, parent);

    }

    private String matchValue(Pattern pattern, String value) {
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }
}
