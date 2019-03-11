package com.xp.config;


import com.xp.component.LoginInterceptor;
import com.xp.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author xp
 * @CreateTime 2019/01/25  18:03
 * @Function 扩展springNVC功能，自定义配置类实现WebMvcConfigurer，重写里面的方法
 * 注解 @EnableWebMvc 表示全面接管springMVC配置,springBoot对springMVC的默认配置失效,一般不用
 */
//@EnableWebMvc
@Configuration
public class ExpandMvcConfig  implements WebMvcConfigurer {

    /**
     *自定义视图映射规则
     *  */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //设置视图映射规则，浏览器发送/xp请求跳转到success.html页面
//        registry.addViewController("/xp").setViewName("success");
//        registry.addViewController("/").setViewName("login");
        registry.addViewController("/").setViewName("index");
        //登陆成功重定向,请求"/success",通过视图名success映射到success.html页面
        registry.addViewController("/success.html").setViewName("success");
        //登陆失败重定向
        registry.addViewController("/login.html").setViewName("login");
    }

    /**
     * 将自定义国际化解析器LocaleResolver加入到容器中
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    /**
     * 注册自定义拦截器
     * springboot已经做好了静态资源映射,拦截器不用来处理静态资源
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/user/login");
    }
}
