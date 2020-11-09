package com.web.crawler.repository;

import com.web.crawler.model.Crawler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CrawlerRepository extends MongoRepository<Crawler, String> {

    Crawler findName(String name);
    Crawler findHashSetValue(String hashSetValue);
}
