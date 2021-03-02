### aop 相关示例
#### aop 三种设计模式 代理，判断和拦截器模式

##### 1、代理模式(Proxy)
 静态代理、动态代理
 
 ```Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h)```
##### 2、判断模式(Predicate)
判断来源：
 类型（Class）
 方法（Method）
 注解（Annotation）
 参数（Parameter）
 异常（Exception）

##### 3、拦截器模式(Interceptor)

### Spring Aop 代理实现（3种）
#### 1、JDK 动态代理实现  - 基于接口实现
#### 2、CGLIB 动态代理实现 - 基于类代理（字节码提升）
#### 3、Aspectj 适配实现 
用的较多的就是 Aspectj