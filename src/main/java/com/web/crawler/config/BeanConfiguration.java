package com.web.crawler.config;

import com.web.crawler.service.CrawlerService;
import com.web.crawler.service.CrawlerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CrawlerService crawlerService() {
        return new CrawlerServiceImpl();
    }
}
