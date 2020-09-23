package com.kwz;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by @KWZ on 2020/7/27 0:22
 */
@Configuration
@MapperScan("com.kwz.mapper")
public class MyBatisPlusConfig {

    @Bean
    PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        return paginationInterceptor;
    }

}
