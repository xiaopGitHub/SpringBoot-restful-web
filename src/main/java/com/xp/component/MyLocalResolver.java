package com.xp.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author xp
 * @CreateTime 2019/02/08  17:25
 * @Function 自定义区域信息解析器,实现手动切换语言
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取跳转链接携带的国际化信息
        String l = request.getParameter("l");
        Locale locale=null;
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            //根据获取的国际化信息新建国际化对象
            locale=new Locale(s[0],s[1] );
        }else{
            locale=new Locale("en","US" );
        }
        //返回国际化对象
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
