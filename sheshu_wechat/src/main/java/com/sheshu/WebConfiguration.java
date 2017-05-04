package com.sheshu;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.Properties;

/**
 * 董帮辉 2017-4-16.
 * 配置类
 */
@Configuration
@MapperScan("com.sheshu.*.mapper")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    //视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/page").setViewName("/index");
    }

    //分页助手
    @Bean
    public PageHelper pagehelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
//        设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用,该参数默认为false,和startPage中的pageNum效果一样
        p.setProperty("offsetAsPageNum", "true");
//        设置为true时，使用RowBounds分页会进行count查询
        p.setProperty("rowBoundsWithCount", "true");
//        启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页
//        禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    //处理编码问题
    @Bean
    public Filter characterEncodingFilter(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }


}
