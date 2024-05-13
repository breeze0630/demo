package com.example.springlearndemo.excel;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 生成动态下拉选项给表格
 * @auther: liubiao
 * @date: 2024-05-11
 */
@Component
@Slf4j
public class SwDictHandlerImpl implements IExcelDictHandler {

    @Override
    public List<Map> getList(String dict) {
        List<Map> list = new ArrayList<>();

        for (int i = 0 ;i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("dictKey", "key"+i);
            map.put("dictValue","value"+i);
            list.add(map);
        }
        return list;
    }

    @Override
    public String toName(String s, Object o, String s1, Object o1) {
        return "";
    }

    @Override
    public String toValue(String s, Object o, String s1, Object o1) {
        return null;
    }
}
