package com.synchrony.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synchrony.project.entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);
    Optional<FileData> findByUsername(String username);
}
