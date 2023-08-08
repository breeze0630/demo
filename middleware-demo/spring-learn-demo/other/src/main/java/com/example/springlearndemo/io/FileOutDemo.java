package com.example.springlearndemo.io;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/19 14:54
 * @Create by external_ll@163.com
 **/
public class FileOutDemo {

    public static void main(String[] args) throws IOException {
        String a = "ffasdfadsfadsfadsfadsfasdfa\n法师法师打发大水发的说法";
        OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream("/Users/liubiao/software/file.txt"), "GBK");
        fileWriter.write(a);
        fileWriter.flush();
        fileWriter.close();
    }
}
