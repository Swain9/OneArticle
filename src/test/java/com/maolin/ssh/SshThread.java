package com.maolin.ssh;

import java.util.Map;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2019-01-07 20:50
 */
public class SshThread extends Thread {
    private Map<String,SshClient> maps;

    public SshThread(Map<String,SshClient> maps){
        this.maps = maps;
    }


    @Override
    public void run() {
        SshClient client = new SshClient();
        try {
            client.login();
            maps.put("aaa", client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
