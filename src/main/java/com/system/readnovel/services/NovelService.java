package com.system.readnovel.services;

import com.system.readnovel.entity.Feedback;
import com.system.readnovel.entity.Novel;

import java.util.List;

public interface NovelService {
    List<Novel> fetchAllNovel();

    List<Novel> findAllNovel();
}
