package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {

    /**

     INSERT INTO `we_safer_lyg`.`sys_user_role_ref` (`user_id`, `role_id`, `owner_id`, `tenant_id`) VALUES ('10000101', '1592099930344083458', '100001', '1000');
    INSERT INTO sys_data_permission (`user_id`,`owner_id`) VALUES ('','mapAll');


     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File userIdTxtFile = new File("/Users/liubiao/Documents/userId3.txt");
        BufferedReader userIdRead = new BufferedReader(new FileReader(userIdTxtFile));
        String userId = null ;
        StringBuilder stringBuilder = new StringBuilder();

        while ( (userId = userIdRead.readLine()) != null){
//            stringBuilder.append("INSERT INTO `we_safer_lyg`.`sys_user_role_ref` (`user_id`, `role_id`, `owner_id`, `tenant_id`) VALUES ('")
//                    .append(userId)
//                    .append("', '1592099930344083458', '100001', '1000');")
//                    .append("\n");
            String[] values =  userId.split(",");
            stringBuilder.append("INSERT INTO sys_data_permission (`user_id`,`owner_id`) VALUES ('")
                    .append(values[0])
                    .append("','")
                    .append(values[1]).append("');")
                    .append("\n");
        }

        FileWriter fileWriter = new FileWriter(new File("/Users/liubiao/Documents/dataPer3.sql"));


        fileWriter.write(stringBuilder.toString());
        fileWriter.flush();

    }
}
