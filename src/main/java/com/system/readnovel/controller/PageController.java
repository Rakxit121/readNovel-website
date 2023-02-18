package com.system.readnovel.controller;


import com.system.readnovel.entity.Novel;
import com.system.readnovel.repo.NovelRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PageController {

    @Autowired
    private NovelRepo novelRepo;

    @GetMapping("/page-data")
    public PageData getPageData(@RequestParam String link) {
        PageData pageData = new PageData();

        try {
            Document document = Jsoup.connect(link).get();
            pageData.setTitle(document.title());

            Elements descriptionElements = document.select("meta[name=description]");
            if (descriptionElements != null && descriptionElements.size() > 0) {
                pageData.setDescription(descriptionElements.get(0).attr("content"));
            }

            Elements authorElements = document.select("div.author-content");
            if (authorElements != null && authorElements.size() > 0) {
                pageData.setAuthor(authorElements.first().text());
            }

            Elements ratingElements = document.select("div.total_votes");
            if (ratingElements != null && ratingElements.size() > 0) {
                pageData.setRating(Integer.parseInt(ratingElements.first().text()));
            }

            Elements genreElements = document.select("div.genres-content");
            if (genreElements != null && genreElements.size() > 0) {
                pageData.setGenre(genreElements.first().text());
            }

            Elements statusElements = document.select("div.summary-content vote-details");
            if (statusElements != null && statusElements.size() > 0) {
                pageData.setStatus(statusElements.first().text());
            }

            Elements latestChapterElements = document.select("div.wp-manga-chapter");
            if (latestChapterElements != null && latestChapterElements.size() > 0) {
                pageData.setLatestChapter(latestChapterElements.first().text());
            }
            Elements LinkElements = document.select("div.wp-manga-chapter");
            if (LinkElements != null && LinkElements.size() > 0) {
                pageData.setLatestChapter(LinkElements.first().text());
            }

            Novel novel = new Novel();
            novel.setTitle(pageData.getTitle());
            novel.setDescription(pageData.getDescription());
            novel.setAuthor(pageData.getAuthor());
            novel.setRating(pageData.getRating());
            novel.setGenre(pageData.getGenre());
            novel.setStatus(pageData.getStatus());
            novel.setLatestChapter(pageData.getLatestChapter());
//            novel.setLink(pageData.getLatestChapter());
            novelRepo.save(novel);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pageData;
    }

}



