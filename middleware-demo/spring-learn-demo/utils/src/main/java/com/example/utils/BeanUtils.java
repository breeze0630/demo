package com.example.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BeanUtils {

    public static void mapToBean(Map<String, Object> map, Object target) {
        try {
            Method[] methods = target.getClass().getMethods();
            if (methods == null || methods.length == 0) {
                return;
            }
            for (Method method : methods) {
                if (method.getName().startsWith("set")) {
                    //截取方法名
                    String mn = method.getName().substring(4);
                    String first = method.getName().substring(3, 4);
                    String methodName = first.toLowerCase() + mn;
                    if (map.containsKey(methodName)) {
                        Object value = map.get(methodName);
                        String valueStr = null;
                        if (value instanceof String || value instanceof Integer || value instanceof Boolean || value instanceof Long || value instanceof Double || value instanceof Float) {
                            valueStr = String.valueOf(value);
                        } else {
                            continue;
                        }
                        Class<?>[] pt = method.getParameterTypes();
                        if (pt != null && pt.length > 0) {
                            String cn = pt[0].getSimpleName();
                            Object arg = null;
                            if (cn.equals("int") || cn.equals("Integer")) {
                                arg = Integer.parseInt(valueStr);
                            } else if (cn.equals("double") || cn.equals("Double")) {
                                arg = Double.parseDouble(valueStr);
                            } else if (cn.equals("float") || cn.equals("Float")) {
                                arg = Float.parseFloat(valueStr);
                            } else if (cn.equals("String")) {
                                arg = valueStr;
                            } else if (cn.equals("boolean") || cn.equals("Boolean")) {
                                arg = Boolean.parseBoolean(valueStr);
                            } else {
                                continue;
                            }
                            method.invoke(target, arg);
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
