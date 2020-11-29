package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.SimpleHttpClient;
import cz.muni.fi.pb162.hw02.crawler.SmartCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Class for representing Crawler of URLs
 *
 * @author Petr Smejkal
 */
public class Crawler implements SmartCrawler {

    @Override
    public List<String> crawl(String url) {
        SimpleHttpClient client = new SimpleHttpClient();
        List<String> urls = new ArrayList<>();
        String webpage = "";
        try {
            webpage = client.get(url);
        } catch (IOException e) {
            System.out.println("Error");
        }
        while (webpage.contains("<a href=\"")) {
            String sublink = webpage.substring(webpage.indexOf("<a href=\"") + 9);
            String[] link = sublink.split("\">", 2);
            urls.add(link[0]);
            webpage = link[1];
        }
        return urls;
    }

    @Override
    public Map<String, List<String>> crawlAll(String url) {
        Map<String, List<String>> map = new HashMap<>();
        Queue<List<String>> queue = new LinkedList<>();
        List<String> crawled = crawl(url);
        queue.add(crawled);
        map.put(url, crawled);
        while (!queue.isEmpty()) {
            List<String> queueUrl = queue.remove();
            for (String html : queueUrl) {
                crawled = crawl(html);
                if (map.containsKey(html) && map.containsValue(crawled)) {
                    continue;
                }
                queue.add(crawled);
                if (map.containsKey(html)) {
                    map.get(html).removeAll(crawled);
                    map.get(html).addAll(crawled);
                } else {
                    map.put(html, crawled);
                }
            }


        }
        return map;
    }

    @Override
    public Map<String, List<String>> crawlReverse(String url) {
        return reverseIndex(crawlAll(url));
    }

    @Override
    public Map<String, List<String>> reverseIndex(Map<String, List<String>> index) {
        Map<String, List<String>> reversed = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : index.entrySet()) {
            reversed.put(entry.getKey(), new ArrayList<>());
        }
        for (Map.Entry<String, List<String>> entry : index.entrySet()) {
            for (String url : entry.getValue()) {
                if (!reversed.containsKey(url)) {
                    reversed.put(url, new ArrayList<String>());
                    reversed.get(url).add(entry.getKey());
                } else {
                    reversed.get(url).add(entry.getKey());
                }
            }
        }
        return reversed;
    }
}
