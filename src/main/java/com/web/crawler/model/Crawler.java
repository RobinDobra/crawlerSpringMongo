package com.web.crawler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.net.URL;
import java.util.HashSet;

@Data
public class Crawler {

    @Id
    public String crawlerId;

    public String name;

    private HashSet<String> links;

    public Crawler() {
        links = new HashSet<String>();
    }

}
