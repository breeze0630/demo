package com.example.middleware.springlearn.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.util.ObjectUtils;

class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    /**
     * Apply this BeanPostProcessor to the given bean instance before its
     * destruction, e.g. invoking custom destruction callbacks.
     * <p>Like DisposableBean's {@code destroy} and a custom destroy method, this
     * callback will only apply to beans which the container fully manages the
     * lifecycle for. This is usually the case for singletons and scoped beans.
     *
     * @param bean     the bean instance to be destroyed
     * @param beanName the name of the bean
     * @throws BeansException in case of errors
     * @see DisposableBean#destroy()
     * @see AbstractBeanDefinition#setDestroyMethodName(String)
     */
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals("userHolder",beanName)){
            System.out.println("postProcessBeforeDestruction() = the user holder V9");
        }
    }
}
