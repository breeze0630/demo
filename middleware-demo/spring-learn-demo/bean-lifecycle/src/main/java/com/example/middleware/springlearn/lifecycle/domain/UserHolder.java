package com.example.middleware.springlearn.lifecycle.domain;


import com.example.springlearndemo.dependencylookup.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

public class UserHolder implements
        EnvironmentAware , BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        InitializingBean,SmartInitializingSingleton {

    private  User user ;

    private int number;
    private String description;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * 执行顺序
     * PostConstruct(使用 注解 {@link PostConstruct} 标注的方法) -> afterPropertiesSet(实现 {@link InitializingBean}) > init-method（XML）中配置
     * */

    @PostConstruct
    public void initPostConstruct(){
        this.description = "the user holder V4";
        System.out.println("initPostConstruct() =  the user holder V4");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.description = "the user holder V5";
        System.out.println("afterPropertiesSet() =  the user holder V5");
    }

    public void init(){
        this.description = "the user holder V6";
        System.out.println("init() =  the user holder V6");
    }



    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("回调 environment 方法");
    }

    /**
     * Callback that supplies the bean {@link ClassLoader class loader} to
     * a bean instance.
     * <p>Invoked <i>after</i> the population of normal bean properties but
     * <i>before</i> an initialization callback such as
     * {@link InitializingBean InitializingBean's}
     * {@link InitializingBean#afterPropertiesSet()}
     * method or a custom init-method.
     *
     * @param classLoader the owning class loader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("回调 classLoader");
    }

    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("回调 beanFactory");
    }

    /**
     * Set the name of the bean in the bean factory that created this bean.
     * <p>Invoked after population of normal bean properties but before an
     * init callback such as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method.
     *
     * @param name the name of the bean in the factory.
     *             Note that this name is the actual bean name used in the factory, which may
     *             differ from the originally specified name: in particular for inner bean
     *             names, the actual bean name might have been made unique through appending
     *             "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
     *             method to extract the original bean name (without suffix), if desired.
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("回调 BeanName");
    }


    /**
     * Invoked right at the end of the singleton pre-instantiation phase,
     * with a guarantee that all regular singleton beans have been created
     * already. {@link ListableBeanFactory#getBeansOfType} calls within
     * this method won't trigger accidental side effects during bootstrap.
     * <p><b>NOTE:</b> This callback won't be triggered for singleton beans
     * lazily initialized on demand after {@link BeanFactory} bootstrap,
     * and not for any other bean scope either. Carefully use it for beans
     * with the intended bootstrap semantics only.
     */
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("afterSingletonsInstantiated() = the user holder V8");
    }

    @Override
    public void finalize() throws Throwable {

        System.out.println("user Holder is finalizd...");
    }

}
