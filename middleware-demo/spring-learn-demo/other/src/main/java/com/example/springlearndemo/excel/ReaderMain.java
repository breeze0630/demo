package com.example.springlearndemo.excel;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/1/10
 */
public class ReaderMain {


    public static Map<String,String> levelMap = new HashMap<>(){{
        put("一级","1562625602821242881");
        put("二级","1562625649831002114");
        put("三级","1562625688607342593");
        put("特级","1562625736317550594"); // 1705105890845274113
        put("运行部（中心）级事故","1743105854825115649");
        put("分公司级事故","1743105930481971202");
        put("一般 C 级事故","1743105984525578241");
        put("一般 B 级事故","1743106046471254017");
        put("一般 A 级事故","1743106258476544001");
        put("较大事故","1743106335249084418");
        put("重大事故","1743106400952856578");
        put("特别重大事故","1743106465457057794");
        put("轻微质量事故","1743106503340011521");
        put("一般质量事故","1743106546256130050");
        put("重大质量事故","1743106593018425346");
        put("特大质量事故","1743106638014918657");
    }};
    public static Map<String,String> typeMap = new HashMap<>(){{

        put("综合管理","1474290387553406978");
        put("进度控制","1475803440015691777");
        put("绿色文明施工","1743159908716589058"); //1705110357913251842
        put("承包商（承运商）管理","1744914111201820673");
        put("质量控制","5849f0023a0ab367a0209793951dd388");
        put("HSE控制","6b53413d4722f4ad4b79062e612fb2ad");
        put("安全问题","cc01f802d8a53321e6d552510905fe5g");
        put("区域维保合同考核条款","1752946453229109250");

    }};


    public static void main(String[] args) throws Exception {
            String sourceFile = "D:\\文档\\公司\\中安承包商2期\\考核材料\\违规条款示例(3)-设备工程部0131追加2.xlsx";
            String outFile = "D:\\文档\\公司\\中安承包商2期\\考核材料\\计分考核-设备工程部0131追加2.sql";
            read(sourceFile,outFile);
    }


    /**



     INSERT INTO `c_violation_repertory`
     (`id`, `type_id`, `clause`, `content`, `region_id`, `number`, `amerce`, `question_type`, `source`, `remark`, `level`, `create_by`, `create_time`, `update_by`, `update_time`, `is_del`, `tenant_id`, `owner_id`,
     `contractor_number`, `foreman`, `safety`, `assistant_manager`, `manager`)
     VALUES
     ('8031fce3694a11eca3322cea7f9555ae', '1474290387553406978', 'EC1115', '未编制有针对性的无损检测方案', NULL, 100,
     10000, '-', NULL, NULL, '1562625602821242881', 'zhangsichu', '2021-12-14 16:23:57', 'zhangsichu', '2021-12-14 16:23:57', 0, '123', '12301', 0, 0, 0, 0, 0);



     *
     * @param sourceFile
     * @param outFile
     * @throws Exception
     */
    public static void read(String sourceFile,String outFile) throws Exception{

        List<ViolationRepertory> repertories = ExcelUtils.importExcel(new FileInputStream(new File(sourceFile)),0,1,ViolationRepertory.class);
        StringBuilder bufferedReader = new StringBuilder();

        for(ViolationRepertory repertory : repertories){
            bufferedReader.append("INSERT INTO `c_violation_repertory`\n" +
                    "     (`id`, `type_id`, `clause`, `content`, `region_id`, `number`, `amerce`, `question_type`, `source`, `remark`, `level`, `create_by`, `create_time`, `update_by`, `update_time`, `is_del`, `tenant_id`, `owner_id`, `contractor_number`, `foreman`, `safety`, `assistant_manager`, `manager`,`amerce_switch`)\n" +
                    "     VALUES")
                    .append(" ('")
                    .append(UUID.randomUUID().toString().replaceAll("-",""))
                    .append("', '")
                    .append(typeMap.get(repertory.getType()))
                    .append("', '")
                    .append(repertory.getClause())
                    .append("', '")
                    .append(repertory.getContent())
                    .append("', NULL, ")

                    .append(repertory.getPersonnel())
                    .append(", ")
                    .append(repertory.getAmount())
                    .append(", ")
                    .append(" '-', NULL, NULL, '")
                    .append(levelMap.get(repertory.getLevel()))
                    .append("', 'system', '2024-01-10 00:00:00', 'system', '2024-01-10 00:00:00', 0, '123', '12301', ")
                    .append(repertory.getCompany())
                    .append(", ")
                    .append(repertory.getForeman())
                    .append(", ")
                    .append(repertory.getSafety())
                    .append(", ")
                    .append(repertory.getAssistantManager())
                    .append(", ")
                    .append(repertory.getManager())
                    .append(",2")
                    .append(");\n");
        }


        FileWriter fileWriter = new FileWriter(new File(outFile));
        fileWriter.write(bufferedReader.toString());
        fileWriter.flush();
        fileWriter.close();

    }
}
