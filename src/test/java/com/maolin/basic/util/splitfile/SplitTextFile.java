package com.maolin.basic.util.splitfile;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-19 14:07
 */
public class SplitTextFile {

    @Test
    public void testPath() {
        Path readPath = Paths.get("E:\\workspace\\ipran\\数据资料\\国际公司SDN海外二层业务\\错误分析\\catalina.out");
        Path parent = readPath.getParent();
        Path path = Paths.get(parent.toString(), "a.txt");

        System.out.println(parent.toString());
        System.out.println(path.toString());
        System.out.println(path.getFileName());
        System.out.println(getNextFileName(path.getFileName().toString()));
    }

    private String getNextFileName(String fileName) {
        long time = System.currentTimeMillis();
        int subIndex = fileName.lastIndexOf(".");
        String nextName = fileName.substring(0, subIndex) + "_" + time + fileName.substring(subIndex);
        return nextName;
    }

    @Test
    public void test2() {

        int i = 0;
        while (true) {

            loopThis:
            while (true) {
                if (i == 10) {
                    i = 0;
                    break loopThis;
                }
                i++;
            }

        }

    }

    public void test3() throws IOException {
        Path readPath = Paths.get("E:\\workspace\\ipran\\数据资料\\国际公司SDN海外二层业务\\错误分析\\catalina.out");
        Path writePath;
        Path parent = readPath.getParent();
        Path fileName = readPath.getFileName();

        BufferedWriter writer;
        try (Stream<String> lines = Files.lines(readPath)) {
            lines.forEach(line -> {

            });
        }
    }

    @Test
    public void test4() throws IOException {
        Path readPath = Paths.get("E:\\workspace\\ipran\\数据资料\\国际公司SDN海外二层业务\\错误分析\\1.txt");
        Path writePath;
        Path parent = readPath.getParent();
        Path fileName = readPath.getFileName();
        InputStream in = Files.newInputStream(readPath);

        BufferedWriter writer;
        int i = 0;
        try {
            while (true) {
                writePath = Paths.get(parent.toString(), getNextFileName(fileName.toString()));
                writer = Files.newBufferedWriter(writePath, Charset.forName("UTF-8"));

                String line;
                byte[] bytes = new byte[4096];
                int len;
                while ((len = in.read(bytes)) != -1) {
                    writer.write(new String(bytes, 0, len));
                }
                writer.flush();
                writer.close();
                break;
            }
        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
        }
    }


    @Test
    public void test1() throws IOException {
        //1406374
        Path readPath = Paths.get("E:\\workspace\\ipran\\数据资料\\国际公司SDN海外二层业务\\错误分析\\catalina.out");
//        Path readPath = Paths.get("F:\\idea_output\\ipran-confsrv.log");
        Path writePath;
        Path parent = readPath.getParent();
        Path fileName = readPath.getFileName();

        BufferedReader reader = Files.newBufferedReader(readPath, Charset.forName("GBK"));
        BufferedWriter writer;
        int i = 0;
        int total = 0;
        try {
            while (true) {
                loopThis:
                {
                    writePath = Paths.get(parent.toString(), getNextFileName(fileName.toString()));
                    writer = Files.newBufferedWriter(writePath, Charset.forName("UTF-8"));

                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (i == 100000) {
                            i = 0;
                            total += 100000;
                            writer.close();
                            break loopThis;
                        }
                        writer.write(line + "\n");
                        i++;
                    }
                    writer.close();
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(i + total);
            e.printStackTrace();
        }
    }
}
