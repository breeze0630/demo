package com.example.springlearndemo.dependencylookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HierarchicalDependencyLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        //TODO 待完善代码

        // 1、获取 HierarchicalBeanFactory <- ConfigurableBeanFactory <- ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        System.out.println("当前BeanFactory 的 父Factory : " + (beanFactory.getParentBeanFactory()));

        // 设置 父 factory
        ConfigurableListableBeanFactory parentBeanFactory = createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);

        System.out.println("当前BeanFactory 的 父Factory : " + (beanFactory.getParentBeanFactory()));

        displayContainsLocalBean(beanFactory,"user");
        displayContainsLocalBean(parentBeanFactory,"user");

        displayContainsBean(beanFactory,"user");
        displayContainsBean(parentBeanFactory,"user");

        applicationContext.close();
    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory,String beanName){
        System.out.printf("当前 BeanFactory [%s] 是否包含 bean [ name : %s ] : %s \n",beanFactory,beanName,
                containsBean(beanFactory,beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory,String beanName){
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if(parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory hierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if(containsBean(hierarchicalBeanFactory,beanName)){
                return true;
            }
        }
        return beanFactory.containsBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory,String beanName){

        System.out.printf("当前 BeanFactory [%s] 是否包含 Local bean [ name : %s ] : %s \n",beanFactory,beanName,beanFactory.containsLocalBean(beanName));

    }
    private static ConfigurableListableBeanFactory createParentBeanFactory(){
        //创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";

        reader.loadBeanDefinitions(location);

        return beanFactory;
    }
}
