package com.maolin.basic.util.timer;

import org.junit.Test;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {


    @Test
    public void testTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器任务");
                timer.cancel();
            }
        }, 1000);
        Scanner input = new Scanner(System.in);
        String next = input.next();
        System.out.println(next);
    }

}
