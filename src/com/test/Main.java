package com.test;

import java.io.*;


public class Main {

    public static void echo(boolean on) {
        try {
            String[] cmd = {
                    "/bin/sh",
                    "-c",
                    "/bin/stty " + (on ? "echo" : "-echo") + " < /dev/tty"
            };
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        } catch (IOException e) {
        } catch (InterruptedException e) {
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            echo(false);
            System.out.println("输入字符 q 退出");
            char c;
            do {
                c = (char) br.read();
                System.out.print(c);
            } while (c != 'q');
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            echo(true);
        }
    }
}
