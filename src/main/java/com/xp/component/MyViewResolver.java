package com.xp.component;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

/**
 * @Author xp
 * @CreateTime 2019/02/07  13:28
 * @Function 自定义视图解析器
 */
public class MyViewResolver {

    /**
     向容器中添加视图解析器
     */
    @Bean
    public ViewResolver diyViewResolver(){
        return null;
    }
}
