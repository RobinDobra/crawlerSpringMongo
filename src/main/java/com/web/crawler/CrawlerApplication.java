package com.web.crawler;

import com.web.crawler.model.Crawler;
import com.web.crawler.repository.CrawlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlerApplication implements CommandLineRunner {

    @Autowired
    private CrawlerRepository crawlerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        crawlerRepository.deleteAll();

        crawlerRepository.save(new Crawler(""));
    }
}
