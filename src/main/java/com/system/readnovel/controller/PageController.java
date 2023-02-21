package com.system.readnovel.controller;


import com.system.readnovel.entity.Novel;
import com.system.readnovel.entity.PageData;
import com.system.readnovel.repo.NovelRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PageController {

    @Autowired
    private NovelRepo novelRepo;

//    @Autowired
//    private PageDataRepository pageDataRepository;

//    @GetMapping("/page-data")
//    public PageData getPageData(@RequestParam String link) {
//        PageData pageData = new PageData();
//
//        try {
//            Document document = Jsoup.connect(link).get();
//            pageData.setTitle(document.title());
//
//            Elements descriptionElements = document.select("meta[name=description]");
//            if (descriptionElements != null && descriptionElements.size() > 0) {
//                pageData.setDescription(descriptionElements.get(0).attr("content"));
//            }
//
//            Elements authorElements = document.select("div.author-content");
//            if (authorElements != null && authorElements.size() > 0) {
//                pageData.setAuthor(authorElements.first().text());
//            }
//
//            Elements ratingElements = document.select("div.total_votes");
//            if (ratingElements != null && ratingElements.size() > 0) {
//                pageData.setRating(Integer.parseInt(ratingElements.first().text()));
//            }
//
//            Elements genreElements = document.select("div.genres-content");
//            if (genreElements != null && genreElements.size() > 0) {
//                pageData.setGenre(genreElements.first().text());
//            }
//
//            Elements statusElements = document.select("div.summary-content vote-details");
//            if (statusElements != null && statusElements.size() > 0) {
//                pageData.setStatus(statusElements.first().text());
//            }
//
//            Elements latestChapterElements = document.select("div.wp-manga-chapter");
//            if (latestChapterElements != null && latestChapterElements.size() > 0) {
//                pageData.setLatestChapter(latestChapterElements.first().text());
//            }
//            Elements LinkElements = document.select("div.wp-manga-chapter");
//            if (LinkElements != null && LinkElements.size() > 0) {
//                pageData.setLatestChapter(LinkElements.first().text());
//            }
//
//            Novel novel = new Novel();
//            novel.setTitle(pageData.getTitle());
//            novel.setDescription(pageData.getDescription());
//            novel.setAuthor(pageData.getAuthor());
//            novel.setRating(pageData.getRating());
//            novel.setGenre(pageData.getGenre());
//            novel.setStatus(pageData.getStatus());
//            novel.setLatestChapter(pageData.getLatestChapter());
////            novel.setLink(pageData.getLatestChapter());
//            novelRepo.save(novel);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return pageData;
//    }
//}
//
////    @PostMapping("/api/page-data")
////    public PageData storePageData(@RequestParam String link, @RequestParam MultipartFile image) {
////        // Validate that the link is not empty
////        if (link.trim().isEmpty()) {
////            throw new IllegalArgumentException("Link cannot be empty");
////        }
////
////        // Validate that the uploaded file is an image
////        if (!image.getContentType().startsWith("image/")) {
////            throw new IllegalArgumentException("File must be an image");
////        }
////
////        // Process the image data
////        byte[] imageData = image.getBytes();
////
////        // Store the data in the database
////        PageData pageData = new PageData(link, imageData);
////        pageDataRepository.save(pageData);
////
////        return pageData;
////    }
////
////
////}
//
//
//


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
            Elements statusElements = document.select("div.summary-content");
            if (statusElements != null && statusElements.size() > 0) {
                pageData.setStatus(statusElements.first().text());
            }

            Elements latestChapterElements = document.select("div.wp-manga-chapter");
            if (latestChapterElements != null && latestChapterElements.size() > 0) {
                pageData.setLatestChapter(latestChapterElements.first().text());
            }

// Save the data in the database
            Novel novel = new Novel();
            novel.setTitle(pageData.getTitle());
            novel.setDescription(pageData.getDescription());
            novel.setAuthor(pageData.getAuthor());
            novel.setRating(pageData.getRating());
            novel.setGenre(pageData.getGenre());
            novel.setStatus(pageData.getStatus());
            novel.setLatestChapter(pageData.getLatestChapter());
            novelRepo.save(novel);
        } catch (IOException e) {
// Handle the exception
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve page data");
        }

// Return the PageData object
        return pageData;
    }
}


//import java.io.IOException;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//    public class PageDataController {
//
//        @Autowired
//        private PageDataRepository pageDataRepository;
//
//        @Autowired
//        private NovelRepository novelRepo;
//
//        @PostMapping("/api/page-data")
//        public PageData storePageData(@RequestParam String link, @RequestParam MultipartFile image) {
//            // Validate that the link is not empty
//            if (link.trim().isEmpty()) {
//                throw new IllegalArgumentException("Link cannot be empty");
//            }
//
//            // Validate that the uploaded file is an image
//            if (!image.getContentType().startsWith("image/")) {
//                throw new IllegalArgumentException("File must be an image");
//            }
//
//            // Process the image data
//            byte[] imageData = new byte[0];
//            try {
//                imageData = image.getBytes();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            // Retrieve the data for the website using the link
//            PageData pageData = new PageData();
//
//            // Extract the data from the website using a library such as Jsoup
//            try {
//                Document document = Jsoup.connect(link).get();
//                pageData.setTitle(document.title());
//
//                Elements descriptionElements = document.select("meta[name=description]");
//                if (descriptionElements != null && descriptionElements.size() > 0) {
//                    pageData.setDescription(descriptionElements.get(0).attr("content"));
//                }
//
//                Elements authorElements = document.select("div.author-content");
//                if (authorElements != null && authorElements.size() > 0) {
//                    pageData.setAuthor(authorElements.first().text());
//                }
//
//                Elements ratingElements = document.select("div.total_votes");
//                if (ratingElements != null && ratingElements.size() > 0) {
//                    pageData.setRating(Integer.parseInt(ratingElements.first().text()));
//                }
//
//                Elements genreElements = document.select("div.genres-content");
//                if (genreElements != null && genreElements.size() > 0) {
//                    pageData.setGenre(genreElements.first().text());
//                }
//                Elements statusElements = document.select("div.summary-content");
//                if (statusElements != null && statusElements.size() > 0) {
//                    pageData.setStatus(statusElements.first().text());
//                }
//
//                Elements latestChapterElements = document.select("div.wp-manga-chapter");
//                if (latestChapterElements != null && latestChapterElements.size() > 0) {
//                    pageData.setLatestChapter(latestChapterElements.first().text());
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//
//            // Save the PageData object to the database
//            pageData.setImage(imageData);
//            pageData.setLink(link);
//            pageDataRepository.save(pageData);
//
//            // Create a new Novel object
//            Novel novel = new Novel();
//            novel.setTitle(pageData.getTitle());
//            novel.setDescription(pageData.getDescription());
//            novel.setAuthor(pageData.getAuthor());
//            novel.setRating(pageData.getRating());
//            novel.setGenre(pageData.getGenre());
//            novel.setStatus(pageData.getStatus());
//            novel.setLatestChapter(pageData.getLatestChapter());
//            novel.setImageData(imageData);
//
//            // Save the Novel object to the database
//            novelRepo.save(novel);
//
//            return pageData;
//        }
//    }






