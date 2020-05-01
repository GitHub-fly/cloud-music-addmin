package com.soft1851.music.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xunmi
 * @ClassName PageConfig
 * @Description TODO
 * @Date 2020/4/23
 * @Version 1.0
 **/
@Configuration
public class PageConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}