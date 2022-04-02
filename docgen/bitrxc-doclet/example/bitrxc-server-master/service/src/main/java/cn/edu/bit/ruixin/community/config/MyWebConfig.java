package cn.edu.bit.ruixin.community.config;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * TODO
 *
 * @author 78165
 * @date 2021/2/19
 */
@Configuration
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class MyWebConfig {

    // @Autowired
    // private GlobalLoginFilter loginFilter;

    // @Bean
    // public FilterRegistrationBean registerBean() {
    //     System.out.println(loginFilter);
    //     FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
    //     registrationBean.setFilter(loginFilter);
    //     registrationBean.addUrlPatterns("/*");
    //     registrationBean.setName("globalAuthenticationFilter");
    //     registrationBean.setOrder(1);
    //     return registrationBean;
    // }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 文件上传Bean multipartResolver
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        multipartResolver.setResolveLazily(true);
        multipartResolver.setMaxInMemorySize(128*1024);
        multipartResolver.setMaxUploadSize(10*1024*1024);
        return multipartResolver;
    }

    // 管理员修改和用户读锁，维护缓存一致性
    @Bean
    public ReadWriteLock readWriteLock() {
        return new ReentrantReadWriteLock();
    }
}
