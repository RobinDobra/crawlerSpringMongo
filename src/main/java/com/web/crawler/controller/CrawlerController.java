package com.web.crawler.controller;

import com.web.crawler.model.Crawler;
import com.web.crawler.repository.CrawlerRepository;
import com.web.crawler.service.CrawlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/crawler")
public class CrawlerController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final CrawlerRepository crawlerRepository;

    private CrawlerService crawlerService;

    public CrawlerController(CrawlerRepository crawlerRepository) {
        this.crawlerRepository = crawlerRepository;
    }

    @Autowired
    public void setCrawlerService(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }

    @RequestMapping("/pagelinks")
    public Crawler getCrawlerPageLinks(Crawler crawler) {
        Crawler crawlerPageLinks = crawlerService.getPageLinks("https://de.wikipedia.org/wiki/Zufall");
        System.out.println("testtesttest");
        return crawlerPageLinks;
    }

    @RequestMapping("/countwords")
    public Crawler countWordsOnLink(Crawler crawler) throws IOException {
        Crawler crawlerWordCount = crawlerService.getWordsWithAtLeastTenLetters("https://de.wikipedia.org/wiki/Zufall");
        System.out.println("testtesttest");
        return crawlerWordCount;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Crawler> getAllUrls() {
        LOG.info("Getting all URLs.");
        return crawlerRepository.findAll();
    }



}
