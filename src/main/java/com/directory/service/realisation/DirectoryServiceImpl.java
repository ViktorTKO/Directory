package com.directory.service.realisation;

import com.directory.domain.entity.DirectoryEntity;
import com.directory.domain.repository.DirectoryRepository;
import com.directory.service.api.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    private DirectoryRepository directoryRepository;
    @Override
    public DirectoryEntity createDirectory(DirectoryEntity directory) {
        return  directoryRepository.save(directory);
    }

    @Override
    @Cacheable("directory")
    public DirectoryEntity getDirectoryById(int id) {
        return directoryRepository.getById(id);
    }

    @Override
    public void deleteDirectoryById(int id) {
    directoryRepository.getById(id);
    }

    @Override
    public List<DirectoryEntity> getAll() {
        return directoryRepository.findAll();
    }

    @Override
    public DirectoryEntity updateDirectory(int id, DirectoryEntity directory) {
        DirectoryEntity directoryEntity =  directoryRepository.getById(id);
        directoryEntity.setId(directory.getId());
        directoryEntity.setName(directory.getName());
        directoryEntity.setShortName(directory.getShortName());
        return (DirectoryEntity) directoryRepository.save(directoryEntity);
    }
}
