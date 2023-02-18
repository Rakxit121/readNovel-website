package com.system.readnovel.repo;

import com.system.readnovel.controller.PageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDataRepository extends JpaRepository<PageData, Long> {
}
