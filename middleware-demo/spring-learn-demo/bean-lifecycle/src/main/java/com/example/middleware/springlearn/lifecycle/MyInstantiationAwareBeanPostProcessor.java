package com.example.middleware.springlearn.lifecycle;

import com.example.middleware.springlearn.lifecycle.domain.UserHolder;
import com.example.springlearndemo.dependencylookup.domain.SuperUser;
import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
   @Override
   public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

       if(ObjectUtils.nullSafeEquals( "superUser",beanName) && SuperUser.class.equals(beanClass)){
           return  new SuperUser();
       }
       //如果返回Null，保持之前的处理过程不变,采用默认的实例化方式
       return null;
   }


   @Override
   public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
       if(ObjectUtils.nullSafeEquals("user",beanName) ){
           User user = (User) bean;
           user.setId(999L);
           user.setName("测试");
           return false;
       }
       return true;
   }


   /**
    * PropertyValues 默认实现 MutablePropertyValues
    * 此方法可修改配置后的参数
    * */
   @Override
   public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
       final MutablePropertyValues propertyValues ;

       if(pvs instanceof  MutablePropertyValues){
           propertyValues = (MutablePropertyValues) pvs;
       }else {
           propertyValues = new MutablePropertyValues();
       }

//       propertyValues.addPropertyValue("number","1");
       if(propertyValues.contains("description")){

           // PropertyValue value 是final 修饰，不能修改，获取没有意义
           // 先移除参数 ，再添加，当然亦可以将参数取出来，加工后重新添加
           propertyValues.addPropertyValue("description","the user Holder V2");

       }
       return propertyValues;
   }



    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       if(ObjectUtils.nullSafeEquals("userHolder",beanName)){
           UserHolder userHolder = (UserHolder) bean;
           userHolder.setDescription("the user Holder V3");
           System.out.println("postProcessBeforeInitialization() = the user Holder V3");
       }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("userHolder",beanName)){
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("the user Holder V7");
            System.out.println("postProcessAfterInitialization() = the user Holder V7");
        }
        return bean;
    }
}
