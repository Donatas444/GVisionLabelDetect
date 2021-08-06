package com.example.gvisionimageobjectdetection.repository;

import com.example.gvisionimageobjectdetection.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query(value = "SELECT * FROM result WHERE result.imageId = ?", nativeQuery = true)
    List<Result> findResultsByImageId(Long imageId);
}
