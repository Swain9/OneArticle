package com.maolin.ssh;

import com.jcraft.jsch.JSchException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-01-07 17:56
 */
public class SSHDemoTest {


    public static void main(String[] arg) throws InterruptedException, IOException, JSchException {
        Map<String, SshClient> maps = new HashMap<>();

        SshThread sshThread = new SshThread(maps);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(sshThread);

        Thread.sleep(10000);

        SshClient client = maps.get("aaa");
        client.write("ll");
        client.read();
        //test3();
        //test2();
        //test1();

    }

    private static void test3() throws InterruptedException {
        Map<String, SshClient> maps = new HashMap<>();

        new SshThread(maps).start();

        Thread.sleep(10000);

        SshClient client = maps.get("aaa");

        new Thread(() -> {
            try {
                client.write("ll");
                client.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void test2() throws InterruptedException, IOException {
        Map<String, SshClient> maps = new HashMap<>();

        new SshThread(maps).start();

        Thread.sleep(10000);

        SshClient client = maps.get("aaa");

        client.write("ll");
        client.read();
    }

    private static void test1() throws InterruptedException {
        SshClient client = new SshClient();

        new Thread(() -> {
            try {
                client.login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        //client.login();

        Thread.sleep(10000);

        new Thread(() -> {
            try {
                client.write("ll");
                client.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


}

