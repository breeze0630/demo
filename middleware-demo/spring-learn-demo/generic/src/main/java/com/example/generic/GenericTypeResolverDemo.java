package com.example.generic;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Date: 2020/9/13 15:09
 * @Create by external_ll@163.com
 **/
public class GenericTypeResolverDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        Method method = GenericTypeResolverDemo.class.getMethod("getString");

        Class<?> returnType = GenericTypeResolver.resolveReturnType(method,GenericTypeResolverDemo.class);

        //常规类型作为方法返回值
        System.out.println(String.class.equals(returnType));

        //输出：null    常规类型不具备泛型参数类型，泛型参数类型指的是如  List<E> 的E，例如有的方法定义为 E getString()
        System.out.println(GenericTypeResolver.resolveReturnTypeArgument(method,GenericTypeResolverDemo.class));



        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,List.class,"getString");

        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,List.class,"getList");

        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,List.class,"getStringList");

        displayReturnTypeGenericInfo(GenericTypeResolverDemo.class,List.class,"getListImpl");


        //会查找当前类及其父类
        Map<TypeVariable, Type> typeVariableTypeMap = GenericTypeResolver.getTypeVariableMap(StringList.class);
        System.out.println(typeVariableTypeMap);

        Map<TypeVariable, Type> typeVariableTypeMap2 = GenericTypeResolver.getTypeVariableMap(StringListImpl.class);
        System.out.println(typeVariableTypeMap2);
    }


    public static <E> List<E> getList(){
        return null;
    }
    public static String getString(){
        return null;
    }

    public static StringList getStringList(){
        return null;
    }


    public static ListImpl getListImpl(){
        return null;
    }

    private static void displayReturnTypeGenericInfo(Class<?> containingClass,Class<?> genericIfc,String methodName,Class... arg) throws NoSuchMethodException {

        Method method = containingClass.getMethod(methodName,arg );

        Class<?> returnType = GenericTypeResolver.resolveReturnType(method,GenericTypeResolverDemo.class);

        //常规类型作为方法返回值
        System.out.printf("GenericTypeResolver.resolveReturnType(%s,%s) = %s \n",methodName,containingClass.getSimpleName(),returnType);

        //如果泛型的参数为非具体类型则输出：null    常规类型不具备泛型参数类型，泛型参数类型指的是如  List<E> 的E，例如有的方法定义为 E getString()
        Class<?> returnTypeArgument = GenericTypeResolver.resolveReturnTypeArgument(method,genericIfc);
        System.out.printf("GenericTypeResolver.resolveReturnTypeArgument(%s,%s) = %s \n",methodName,containingClass.getSimpleName(),returnTypeArgument);

    }

    class StringList extends ArrayList<String > { //泛型已经具体化，resolveReturnTypeArgument 有正常返回，否则为空

    }

    class StringListImpl extends ListImpl<String>{

    }
}
