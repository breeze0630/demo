package com.example.converter.conversion;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Description
 * @Date: 2020/9/10 23:24
 * @Create by external_ll@163.com
 **/
public class PropertiesToStringConverter implements ConditionalGenericConverter
{

    /**
     * 匹配类型
     * */
    @Override
    public boolean matches(TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {
        return Properties.class.equals(typeDescriptor.getObjectType()) && String.class.equals(typeDescriptor1.getObjectType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Properties.class,String.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor typeDescriptor, TypeDescriptor typeDescriptor1) {

        Properties properties = (Properties) source;

        StringBuilder textBuilder = new StringBuilder();

        for(Map.Entry<Object,Object> entry : properties.entrySet()){
            textBuilder.append(entry.getKey() ).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
        }
        return textBuilder.toString();
    }
}
