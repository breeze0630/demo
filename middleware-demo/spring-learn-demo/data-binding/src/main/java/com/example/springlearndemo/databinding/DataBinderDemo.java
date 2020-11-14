package com.example.springlearndemo.databinding;


import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/18 20:53
 * @Create by external_ll@163.com
 **/
public class DataBinderDemo {

    public static void main(String[] args) {
        User user = new User();

        DataBinder dataBinder = new DataBinder(user,"");

        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","刘彪22");
        map.put("age",22);

        map.put("company"," a ");

        //ignoreUnknownFields 忽略未知属性
        //ignoreInvalidFields
        //autoGrowNestedPaths 属性的嵌套

        //DataBinder 会忽略未知属性
        PropertyValues propertyValues = new MutablePropertyValues(map);
        dataBinder.bind(propertyValues);

        System.out.println(user);
    }
}
