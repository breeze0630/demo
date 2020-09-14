package com.example.springlearndemo.test;

/**
 * @Description
 * @Date: 2020/9/13 14:27
 * @Create by external_ll@163.com
 **/
public class FunctionInterfaceTestImpl implements FunctionInterfaceTest{

    private FunctionInterfaceTest target;

    FunctionInterfaceTestImpl(){}

    FunctionInterfaceTestImpl(FunctionInterfaceTest test){
        target  = test;
    }

    @Override
    public void test() {
        target.test();
//        System.out.println("FunctionInterfaceTestImpl.test");
    }

    public void run(){
        System.out.println("FunctionInterfaceTestImpl.run");
    }
}
