package com.breeze.sample.canaldemo.config;

import cn.hutool.json.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @auther: liubiao
 * @date: 2025-02-27
 */
@Configuration
@Slf4j
public class CanalConfiguration {

    @Value("${spring.canal.server.host}")
    private String canalServer;

    @Value("${spring.canal.server.port}")
    private Integer canalServerPort;

    @Value("${spring.canal.instance.destination}")
    private String destination;


    @Value("${spring.canal.instance.username}")
    private String username;

    @Value("${spring.canal.instance.password}")
    private String password;


    @PostConstruct
    public void init(){

        InetSocketAddress  address = new InetSocketAddress(canalServer,canalServerPort);

        CanalConnector canalConnector = CanalConnectors.newSingleConnector(address,destination,username,password);

        new Thread(()->{
            canalConnector.connect();
            //订阅所有的数据库和表，此处可以修改设置仅订阅一部分
            canalConnector.subscribe(".*\\..*");
            try {
                while (true){
                    // 获取指定数量的变更事件 ，此处设置的为100条
                    Message message = canalConnector.getWithoutAck(100);
                    long messageId = message.getId();
                    if(messageId != -1 &&
                         message.getEntries().size()>0){
                        // 此处为具体的数据处理，自己定义编写，根据实际需要
                        this.processEntris(message.getEntries());
                    }

                    // 处理完成、提交确认
                    canalConnector.ack(messageId);


                }
            }catch (Exception e){
                new RuntimeException(e);
            }finally {
                canalConnector.disconnect();
            }
        }).start();
    }

    public void processEntris(List<CanalEntry.Entry> entries) throws InvalidProtocolBufferException {

        for(CanalEntry.Entry entry : entries){
            //获取表名
            String tableName = entry.getHeader().getTableName();

            //获取事件类型，INSERT、UPDATE、DELETE
            CanalEntry.EntryType entryType = entry.getEntryType();

            //获取序列化后的数据
            ByteString storeValue = entry.getStoreValue();

            //判断类型
            if(CanalEntry.EntryType.ROWDATA.equals(entryType)){
                //反序列化数据
                CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(storeValue);

                //获取事件类型
                CanalEntry.EventType eventType = rowChange.getEventType();

                String sql = rowChange.getSql();
                log.info("sql:{}",sql);



                List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
                for(CanalEntry.RowData rowData : rowDatasList){
                    JSONObject beforeData = new JSONObject();

                    List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();

                    for(CanalEntry.Column column : beforeColumnsList){
                        beforeData.put(column.getName(),column.getValue());
                    }
                    JSONObject afterData = new JSONObject();
                    List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();

                    for(CanalEntry.Column column : afterColumnsList){
                        afterData.put(column.getName(),column.getValue());
                    }

                    log.info("Table:{},EntryType:{},EventType:{},Before:{},After:{}",tableName,entryType,eventType,beforeData,afterData);

                }

            }else {
                log.info("当前操作类型:{}",entryType.getValueDescriptor().getName());
            }

        }

    }

}
