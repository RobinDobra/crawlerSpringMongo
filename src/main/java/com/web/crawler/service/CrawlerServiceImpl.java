package com.web.crawler.service;

import com.web.crawler.model.Crawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CrawlerServiceImpl implements CrawlerService {
    Crawler crawler = new Crawler();

    public Crawler getPageLinks(String URL) {
        //4. Check if you have already crawled the URLs
        //(we are intentionally not checking for duplicate content in this example)
        if (!crawler.getLinks().contains(URL)) {
            try {
                //4. (i) If not add it to the index
                if (crawler.getLinks().add(URL)) {
                    System.out.println(URL);
                }

                //2. Fetch the HTML code
                Document document = Jsoup.connect(URL).get();
                //3. Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("a[href]");

                //5. For each extracted URL... go back to Step 4.
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"));
                }
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Crawler getWordsWithAtLeastTenLetters(String URL) throws IOException {
        Document document = Jsoup.connect(URL).get();
        Element body = document.body();
        String allText = body.text();
        String[] words = allText.split("\\s+");
        for (String word : words) {
            if (word.length() >= 20) {
                System.out.println(word);
            }
        }
        System.out.println(allText);
        return null;
    }
}
