package com.example.springlearndemo.kaoshi;


import java.io.File;
import java.util.ArrayList;

public class T3 {
    public static void main(String[] args)   {
        File file = null;
        String dirPath = "/Users/liubiao/Downloads/jdk1.7.0_79";
        ArrayList<String> fileNameList = new ArrayList<>();
        file = new File(dirPath);
        if(!file.isDirectory()){
            System.out.printf("当前路径为文件 文件为：%s \n",file.getName());
        }else {
            //遍历得到文件名
            getFileName(dirPath,fileNameList);
        }
        System.out.printf("文件总数: %s",fileNameList.size());

    }

    public static void getFileName(String path, ArrayList<String> fileNameList) {
        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                fileNameList.add(tempList[i].getName());
            }
            if (tempList[i].isDirectory()) {
                getFileName(tempList[i].getAbsolutePath(),fileNameList);
            }
        }
        return;
    }



}
