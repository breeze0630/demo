package com.example.middleware.springlearn.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * 处理User.xsd 的 Namespace
 * */
public class UsersNamespaceHandler extends NamespaceHandlerSupport {


    @Override
    public void init() {
        //注册 element 节点
        this.registerBeanDefinitionParser("user" ,new UserBeanDefinitionParser());
    }
}
