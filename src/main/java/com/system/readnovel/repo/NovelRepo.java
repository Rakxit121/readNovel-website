package com.system.readnovel.repo;

import com.system.readnovel.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepo extends JpaRepository<Novel, Long> {

}
