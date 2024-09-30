//package com.example.mybatisplusexample.controller;
//
//import com.example.mybatisplusexample.db.SysPersonnel;
//import com.example.mybatisplusexample.util.Sm4Util;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @description:
// * @auther: liubiao
// * @date: 2023/7/6
// */
//public class Test {
//    private static final String privateKey = "86C63180C2806ED1F47B859DE501215B";
//
//    public static void main(String[] args) throws Exception {
//        File file = new File("D:\\personnel.txt");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        String line = null;
//        List<SysPersonnel> sysPersonnelList = new ArrayList<>();
//        while ( (line = reader.readLine()) != null){
//            SysPersonnel sysPersonnel = new SysPersonnel();
//            String[] array = line.split(",");
//            sysPersonnel.setId(array[0]);
//            sysPersonnel.setIdNo(array[1]);
//            sysPersonnelList.add(sysPersonnel);
//        }
//        sysPersonnelList.forEach( k-> {
//            if(k.getIdNo().length() > 24)
//            {
//                try {
//                    k.setIdNo(Sm4Util.decryptEcb(privateKey, k.getIdNo()));
//                }catch (Exception e){
//
//                }
//            }
//        });
//
//        Map<String,List<SysPersonnel>> personnelMap = sysPersonnelList.stream().collect(Collectors.groupingBy(SysPersonnel::getIdNo));
//        personnelMap.forEach( (k,v) -> {
//            if(v.size() > 1){
//                System.out.println(v.get(0).getId()+",");
//            }
//        });
//
//    }
//}
