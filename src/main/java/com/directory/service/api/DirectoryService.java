package com.directory.service.api;

import com.directory.domain.entity.DirectoryEntity;

import java.util.List;

public interface DirectoryService {

    DirectoryEntity createDirectory(DirectoryEntity directory);
    DirectoryEntity getDirectoryById(int id);
    void deleteDirectoryById(int id);
    List<DirectoryEntity> getAll();
    DirectoryEntity updateDirectory(int id, DirectoryEntity directory);
}
