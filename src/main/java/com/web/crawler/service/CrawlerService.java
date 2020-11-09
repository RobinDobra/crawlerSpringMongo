package com.web.crawler.service;

import com.web.crawler.model.Crawler;

import java.io.IOException;

public interface CrawlerService {
    Crawler crawler = new Crawler();

    Crawler getPageLinks(String URL);

    Crawler getWordsWithAtLeastTenLetters(String URL) throws IOException;
}
