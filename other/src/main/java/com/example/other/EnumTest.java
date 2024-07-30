package com.example.other;

import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.EasyExcel;
import jakarta.persistence.Id;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-07-24
 */
public class EnumTest {

    public  static List<Long> tenantIdList = Arrays.asList(1813815262197936130L,1813894721198440450L
            ,1814108156507041794L
            ,1815306416202518530L
            ,1815561478015340546L);

    public static void main(String[] args) {
        process("D:\\文档\\天邦\\开发文档\\字典第一期刘彪.xlsx", "D:\\文档\\天邦\\开发文档\\字典第一期刘彪2.sql");
    }

    public static void process(String path, String outPath) {
        try {

            MyListener myListener = new MyListener();
            EasyExcel.read(path, EnumImport.class, myListener).sheet().doRead();

            convertList(myListener.getCachedDataList(),outPath);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void convertList(List<EnumImport> importDataList, String outPath) throws IOException {

        /**

         INSERT INTO `sys_dict_type` (`id`, `dict_type`, `dict_name`, `tree_path`, `custom_flag`, `note`, `sort`, `create_time`, `create_by`, `update_time`, `update_by`, `tenant_id`)
         VALUES (100812589029654533, '1001', '公司性质', '/0/1001', 1, '公司性质', 1, '2024-07-19 11:48:40', 'system', '2024-07-19 11:48:40', 'system', '1');


         INSERT INTO `T_Architecture_Data_EnumItem` (`ID`, `DTM_ADD_TIME`, `DTM_EDIT_TIME`, `NVC_TREE_PATH`, `NVC_ENUM_CODE`, `NVC_PARENT_CODE`, `NVC_NAME`, `INT_SORT`, `NVC_ALLOW_DEL`, `NVC_NOTE`, `tenant_id`)
         VALUES ('01667bb39ac543abbc15a87af48a211e', '2024-07-19 11:50:30', '2024-07-19 14:13:05', '/0/1001/10011001', '10011001', '1001', '有限责任公司', 2, '1', '公司性质', 1);
         *
         */
        String keyTemp = "INSERT INTO `sys_dict_type` (`id`, `dict_type`, `dict_name`, `tree_path`, `custom_flag`, `note`, `sort`, `create_time`, `create_by`, `update_time`, `update_by`, `tenant_id`)\n" +
                "         VALUES (%s, '%s', '%s', '%s', %s, '%s', %s, '%s', '%s', '%s', '%s', '%s');";

        String valueTemp = "INSERT INTO `T_Architecture_Data_EnumItem` (`ID`, `DTM_ADD_TIME`, `DTM_EDIT_TIME`, `NVC_TREE_PATH`, `NVC_ENUM_CODE`, `NVC_PARENT_CODE`, `NVC_NAME`, `INT_SORT`, `NVC_ALLOW_DEL`, `NVC_NOTE`, `tenant_id`) \n" +
                "         VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, '%s', '%s', %s);";
        StringBuilder keyBuilder = new StringBuilder();
        StringBuilder valueBuilder = new StringBuilder();
        // 0 不允许 1 允许自定义
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String parentPath = "";
        String parentCode = "";
        Integer customFlag = -1;
        for (EnumImport enumImport : importDataList) {
            if (StringUtils.isNotEmpty(enumImport.getKeyCode())) {
                //当前节点为包含key
                keyBuilder.append(String.format(keyTemp
                        , IdUtil.getSnowflake().nextId()
                        , enumImport.getKeyCode()
                        , enumImport.getKeyName()
                        , "/0/" + enumImport.getKeyCode()
                        , "是".equals(enumImport.getCustomerFlag()) ? 1 : 0
                        , StringUtils.isNotEmpty(enumImport.getNotes()) ? enumImport.getNotes() : ""
                        , 0
                        , time
                        , "system"
                        , time
                        , "system"
                        , 0
                ));
                keyBuilder.append("\n");
                customFlag = "是".equals(enumImport.getCustomerFlag()) ? 1 : 0;
                parentPath = "/0/" + enumImport.getKeyCode();
                parentCode = enumImport.getKeyCode();
            }


                if(customFlag == 0) {
                    valueBuilder.append(String.format(valueTemp
                            , IdUtil.getSnowflake().nextId()
                            , time
                            , time
                            , parentPath + "/" + enumImport.getEnumCode()
                            , enumImport.getEnumCode()
                            , parentCode
                            , enumImport.getEnumName()
                            , 0
                            , 1
                            , StringUtils.isNotEmpty(enumImport.getNotes()) ? enumImport.getNotes() : ""
                            , 0
                    ));
                    valueBuilder.append("\n");
                }else {
                    for(Long tenantId : tenantIdList){
                        valueBuilder.append(String.format(valueTemp
                                , IdUtil.getSnowflake().nextId()
                                , time
                                , time
                                , parentPath + "/" + enumImport.getEnumCode()
                                , enumImport.getEnumCode()
                                , parentCode
                                , enumImport.getEnumName()
                                , 0
                                , 1
                                , StringUtils.isNotEmpty(enumImport.getNotes()) ? enumImport.getNotes() : ""
                                , tenantId
                        ));
                        valueBuilder.append("\n");
                    }
                }
        }
        StringBuilder all = keyBuilder.append(valueBuilder);

        File outFile = new File(outPath);
        outFile.createNewFile();
        FileWriter fw = new FileWriter((outFile));
        fw.write(all.toString());
        fw.flush();
        fw.close();
    }


}
