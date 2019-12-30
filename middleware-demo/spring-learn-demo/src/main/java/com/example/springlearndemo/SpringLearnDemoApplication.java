package com.example.springlearndemo;


import com.example.springlearndemo.annotation.TransactionalService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@TransactionalService(name = "cccc")
public class SpringLearnDemoApplication {


    public static void main(String[] args) throws IOException {

        //@TransactionalService 标注在当前类上
        String className = SpringLearnDemoApplication.class.getName();
        //构建MetadataReaderFactory
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        annotationMetadata.getAnnotationTypes().forEach(annotationType -> {

            System.out.println("外层");
            Set<String> metaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            metaAnnotationTypes.forEach(metaAnnotationType -> {
                System.out.printf("注解 @%s 元标注 @%s \n",annotationType,metaAnnotationType);
            });
        });
    }

}
