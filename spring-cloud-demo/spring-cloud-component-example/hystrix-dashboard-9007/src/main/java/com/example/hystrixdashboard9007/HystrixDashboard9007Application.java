package com.example.hystrixdashboard9007;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//@EnableHystrix
public class HystrixDashboard9007Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9007Application.class, args);
    }


    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，SpringCloud本身无关，
     * ServletRegistrationBean因为springboot的默认路径不是 /hystrix.stream
     *
     *
     * @return
     */
/*    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);

        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/
}
