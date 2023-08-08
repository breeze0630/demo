package com.example.springlearndemo.io;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Map;


public class PT {

    /**
     *
     * insert into td_province_city (code,name,level_type,parent_id) value();
     * */
    public static void main(String[] args) throws Exception{
        category();
    }

    public static void category() throws Exception{
        File file = new File("/Users/liubiao/Documents/code/niucai/Adapay枚举数据表.xlsx");
        Workbook workbook = new XSSFWorkbook(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);
        //表头不需要
        String type1 = "";
        int type1Id = 0;

        String type2 = "";
        int type2Id = 0;

        int id = 0;

        // 一级：insert into td_category (id,category,level_type,parent_id) value();
        // 二级：insert into td_category (id,category,level_type,parent_id) value();
        // 三级：insert into td_category (id,category,level_type,parent_id,mcc,cls_id,category_id) value();

        StringBuffer sqlSb = new StringBuffer();
        for(int i = 2; i< sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            //列
            int j = 0;
            if( row == null || row.getCell(0) == null){
                break;
            }
            String type1Inner = row.getCell(0).getStringCellValue();
            if(StringUtils.isEmpty(type1Inner)){
                break;
            }
            if(!type1Inner.equals(type1)){
                type1  = type1Inner;
                id++;
                type1Id = id;

                //需要插入新的一级类目
                sqlSb.append("insert into td_category (id,category,level_type,parent_id) value(")
                        .append(""+type1Id+",")
                        .append("'"+type1+"',")
                        .append(""+1+",")
                        .append("0")
                        .append(");\n");
            }

            String type2Inner = row.getCell(1).getStringCellValue();
            if(!type2Inner.equals(type2)){
                //需要插入新的二级类目
                type2 = type2Inner;
                id++;
                type2Id = id ;
                sqlSb.append("insert into td_category (id,category,level_type,parent_id) value(")
                        .append(""+type2Id+",")
                        .append("'"+type2+"',")
                        .append(""+2+",")
                        .append(type1Id)
                        .append(");\n");
            }

            String type3Inner = row.getCell(2).getStringCellValue();
            id++;
            sqlSb.append("insert into td_category (id,category,level_type,parent_id,company,person,mcc,cls_id,category_id) value(")
                    .append(""+id+",")
                    .append("'"+type3Inner+"',")
                    .append(""+3+",")
                    .append(type2Id+",")
                    .append("'"+ NumberToTextConverter.toText(row.getCell(3).getNumericCellValue())+"',")
                    .append("'"+NumberToTextConverter.toText(row.getCell(4).getNumericCellValue())+"',")
                    .append("'"+NumberToTextConverter.toText(row.getCell(5).getNumericCellValue())+"',")
                    .append("'"+NumberToTextConverter.toText(row.getCell(6).getNumericCellValue())+"',")
                    .append("'"+(row.getCell(7).getStringCellValue())+"'")
                    .append(");\n");

        }

        System.out.println(sqlSb.toString());


        OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream("/Users/liubiao/Documents/code/niucai/经营类目.sql"), "UTF-8");
        fileWriter.write(sqlSb.toString());
        fileWriter.flush();
        fileWriter.close();
        workbook.close();
    }


    public static void bank() throws Exception{
        StringBuffer sbResult = new StringBuffer();
        String source = "工商银行\t01020000\n" +
                "农业银行\t01030000\n" +
                "中国银行\t01040000\n" +
                "建设银行\t01050000\n" +
                "交通银行\t03010000\n" +
                "平安银行\t03134402\n" +
                "中信银行\t03020000\n" +
                "光大银行\t03030000\n" +
                "华夏银行\t03040000\n" +
                "民生银行\t03050000\n" +
                "广发银行\t03060000\n" +
                "招商银行\t03080000\n" +
                "兴业银行\t03090000\n" +
                "浦发银行\t03100000\n" +
                "北京银行\t03130011\n" +
                "天津银行\t03130012\n" +
                "上海银行\t03130031\n" +
                "江苏银行\t03130032\n" +
                "重庆银行\t03130050\n" +
                "大连银行\t03132102\n" +
                "哈尔滨银行\t03132301\n" +
                "南京银行\t03133201\n" +
                "杭州银行\t03133301\n" +
                "宁波银行\t03133302\n" +
                "温州银行\t03133308\n" +
                "恒丰银行\t03150000\n" +
                "浙商银行\t03160000\n";
        String[] str = source.split("\\n");
        //insert into td_bank (bank_code,bank_name) value();
        for(String bank : str){
            String[] bankInfo = bank.split("\\t");
            sbResult.append("insert into td_bank (bank_code,bank_name) value(")
                    .append("'"+bankInfo[1]+"',")
                    .append("'"+bankInfo[0]+"'")
                    .append(");\n");
        }
        System.out.println(sbResult.toString());


        OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream("/Users/liubiao/Documents/code/niucai/银行.sql"), "UTF-8");
        fileWriter.write(sbResult.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    //insert into td_province_city_area (code,name,level_type,parent_id) value();
    public static void pta () throws Exception{
        String ptPath = "/Users/liubiao/Documents/code/niucai/省市地区.json";

        Reader reader = new InputStreamReader(new FileInputStream(ptPath),
                "Utf-8");
        int ch = 0;
        String jsonStr = null;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        reader.close();
        jsonStr = sb.toString();
        StringBuffer sbResult = new StringBuffer();

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        for(Map.Entry entry:jsonObject.entrySet()){
            String provinceName = (String)entry.getKey();
            JSONObject provinceObject = (JSONObject) entry.getValue();
            String provinceCode = (String) provinceObject.get("val");
            //省份插入
            sbResult.append("insert into td_province_city_area (code,name,level_type,parent_id) value(")
                    .append("'"+provinceCode+"',")
                    .append("'"+provinceName+"',")
                    .append("1,")
                    .append("0")
                    .append(");\n");
            JSONObject cityMap = (JSONObject) provinceObject.get("items");
            for(Map.Entry cityEntry : cityMap.entrySet()){
                String cityName = (String)cityEntry.getKey();
                JSONObject cityObject = (JSONObject) cityEntry.getValue();
                String cityCode = (String) cityObject.get("val");
                sbResult.append("insert into td_province_city_area (code,name,level_type,parent_id) value(")
                        .append("'"+cityCode+"',")
                        .append("'"+cityName+"',")
                        .append("2,")
                        .append(provinceCode)
                        .append(");\n");
                JSONObject areaMap = (JSONObject) cityObject.get("items");
                if(areaMap != null) {
                    for (Map.Entry areaEntry : areaMap.entrySet()) {
                        String areaName = (String) areaEntry.getKey();
                        String areaCode = (String) areaEntry.getValue();
                        sbResult.append("insert into td_province_city_area (code,name,level_type,parent_id) value(")
                                .append("'" + areaCode + "',")
                                .append("'" + areaName + "',")
                                .append("3,")
                                .append(cityCode)
                                .append(");\n");
                    }
                }

            }
        }

        System.out.println(sbResult.toString());


        OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream("/Users/liubiao/Documents/code/niucai/省市地区表.sql"), "UTF-8");
        fileWriter.write(sbResult.toString());
        fileWriter.flush();
        fileWriter.close();
    }


    public static void pt() throws Exception{
        String ptPath = "/Users/liubiao/Documents/code/niucai/省市表.json";

        Reader reader = new InputStreamReader(new FileInputStream(ptPath),
                "Utf-8");
        int ch = 0;
        String jsonStr = null;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        reader.close();
        jsonStr = sb.toString();
        JSONArray jsonArr = JSONArray.parseArray(jsonStr);
        StringBuffer sbResult = new StringBuffer();
        jsonArr.forEach( k -> {
            JSONObject jsonObject = (JSONObject)k;
            String provinceCode = (String)jsonObject.get("value");
            String provinceName = (String)jsonObject.get("title");
            sbResult.append("insert into td_province_city (code,name,level_type,parent_id) value(")
                    .append("'"+provinceCode+"',")
                    .append("'"+provinceName+"',")
                    .append("'"+1 +"',")
                    .append("'"+0 +"'")
                    .append(");").append("\n");
            JSONArray citys = (JSONArray) jsonObject.getJSONArray("cities");
            citys.forEach( j -> {

                JSONObject jsonObject1 = (JSONObject) j ;
                String cityCode = (String)jsonObject1.get("value");
                String cityName = (String)jsonObject1.get("title");

                sbResult.append("insert into td_province_city (code,name,level_type,parent_id) value(")
                        .append("'"+cityCode+"',")
                        .append("'"+cityName+"',")
                        .append(""+2 +",")
                        .append("'"+provinceCode +"'")
                        .append(");").append("\n");
            });
        });

        System.out.println(sbResult.toString());


        OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream("/Users/liubiao/Documents/code/niucai/省市表.sql"), "UTF-8");
        fileWriter.write(sbResult.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
