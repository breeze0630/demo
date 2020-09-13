package com.example.generic;

import org.springframework.core.ResolvableType;

/**
 * @Description
 * @Date: 2020/9/13 17:06
 * @Create by external_ll@163.com
 **/
public class ResolvableTypeDemo {

    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(GenericTypeResolverDemo.StringList.class);

        resolvableType.getSuperType() ; //ArrayList
        resolvableType.getSuperType().getSuperType() ;//AbstractList
        System.out.println(resolvableType.resolve());
        System.out.println(resolvableType.asCollection().resolveGeneric(0));
    }
}
