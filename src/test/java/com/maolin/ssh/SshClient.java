package com.maolin.ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-01-07 19:31
 */
public class SshClient {
    private InputStream in;
    private PrintWriter out;

    public void login() throws JSchException, IOException {
        JSch jsch = new JSch();


        String user = "root";
        String host = "172.168.10.7";
        Session session = jsch.getSession(user, host, 22);

        String passwd = "rot@2016";
        session.setPassword(passwd);

        UserInfo ui = new SshClient.MyUserInfo() {
            public void showMessage(String message) {
                System.out.println("【showMessage】：" + message);
            }

            public boolean promptYesNo(String message) {
                System.out.println("【promptYesNo】：" + message);
                return true;

            }
        };
        session.setUserInfo(ui);
        session.connect(30000);

        Channel channel = session.openChannel("shell");

        in = channel.getInputStream();
        out = new PrintWriter(channel.getOutputStream());

        channel.connect(3 * 1000);
    }

    public void write(String s) {
        out.print(s);
        out.print("\n");
        out.flush();
    }

    public void read() throws IOException {
        byte[] buffed = new byte[1024 * 1024 * 4];
        int len = 0;
        while ((len = in.read(buffed)) != -1) {
            System.out.println(new String(buffed, 0, len));
        }
    }

    public static abstract class MyUserInfo
            implements UserInfo, UIKeyboardInteractive {
        public String getPassword() {
            return null;
        }

        public boolean promptYesNo(String str) {
            return false;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return false;
        }

        public boolean promptPassword(String message) {
            return false;
        }

        public void showMessage(String message) {
        }

        public String[] promptKeyboardInteractive(String destination,
                                                  String name,
                                                  String instruction,
                                                  String[] prompt,
                                                  boolean[] echo) {
            return null;
        }
    }
}
