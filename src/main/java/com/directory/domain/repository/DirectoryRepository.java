package com.directory.domain.repository;


import com.directory.domain.entity.DirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<DirectoryEntity, Integer> {
}
