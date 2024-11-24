package com.demo.sharding.sphere.demo;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demo.sharding.sphere.demo.entity.Account;
import com.demo.sharding.sphere.demo.entity.DictType;
import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.mapper.AccountMapper;
import com.demo.sharding.sphere.demo.mapper.DictTypeMapper;
import com.demo.sharding.sphere.demo.mapper.OrderMapper;
import com.demo.sharding.sphere.demo.util.LocalIdUtil;
import com.demo.sharding.sphere.demo.util.LocalSnowflake;
import com.demo.sharding.sphere.demo.vo.OrderVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @auther: liubiao
 * @date: 2024-11-23
 */

@SpringBootTest
public class SQLTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private DictTypeMapper dictTypeMapper;
    @Test
    public void test() {
        LocalSnowflake snowflake =  LocalIdUtil.getSnowflake();
        int size  = 100;
        for( int index = 0; index < size; index++){
            Order order = new Order();
            long id = snowflake.nextId();
//            order.setOrderId(id);
            order.setUserId(id);
            order.setName("name"+id);
            orderMapper.insert(order);
        }

    }

    @Test
    public void selectTest() {

        List<Order> list = orderMapper.selectList(Wrappers.lambdaQuery(Order.class)
                .like(Order::getName, "name"));
        System.out.println("list: \n"+ JSON.toJSONString(list));


        List<Order> list2 = orderMapper.selectList(Wrappers.lambdaQuery(Order.class)
                .le(Order::getOrderId, 1000000L));
        System.out.println("list2: \n"+ JSON.toJSONString(list2));
    }

    @Test
    public void  testSaveDictType () {

        int size  = 100;
        for( int index = 0; index < size; index++){
            DictType dictType = new DictType();
            dictType.setName("type"+index);
            dictTypeMapper.insert(dictType);
        }
    }
    @Test
    public void testGetDictType() {
        List<DictType> list = dictTypeMapper.selectList(Wrappers.lambdaQuery(DictType.class));
        list.forEach(System.out::println);
    }
    @Test
    public void testGetAccount() {
        List<Account> list = accountMapper.selectList(Wrappers.lambdaQuery(Account.class));
        list.forEach(System.out::println);
    }

    @Test
    public void testGetOrderList() {
        List<OrderVo> list = orderMapper.getOrderList();
        list.removeIf(item-> item.getUserName() == null);
        list.forEach(System.out::println);
    }
}
