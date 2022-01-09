package com.directory.controller;


import com.directory.domain.entity.DirectoryEntity;
import com.directory.model.DirectoryDTO;
import com.directory.service.api.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1.0/directory")
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;

    @GetMapping
    public ResponseEntity<List<DirectoryDTO>> get() {
        List<DirectoryEntity> listOfDirectories = directoryService.getAll();
        List<DirectoryDTO> listOfDirectoryDTO = new ArrayList<>();
        for (DirectoryEntity entity : listOfDirectories
        ) {
            listOfDirectoryDTO.add(new DirectoryDTO().convertDirectoryEntityToDTO(entity));
        }
        return ResponseEntity.ok(listOfDirectoryDTO);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<DirectoryDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(new DirectoryDTO().convertDirectoryEntityToDTO(directoryService.getDirectoryById(id)));
    }

    @PostMapping(value = "/post")
    public ResponseEntity<DirectoryDTO> create(@RequestBody DirectoryDTO directoryDTO) {
        DirectoryDTO oldDirectoryDTO = new DirectoryDTO();
        DirectoryDTO newDirectoryDTO = oldDirectoryDTO.convertDirectoryEntityToDTO(directoryService.createDirectory(
                oldDirectoryDTO.convertDirectoryDTOToDirectoryEntity(directoryDTO)
        ));
        return ResponseEntity.ok(newDirectoryDTO);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<DirectoryDTO> edit(@PathVariable int id, DirectoryDTO directoryDTO) {
        DirectoryDTO oldDirectoryDTO = new DirectoryDTO();
        DirectoryDTO updatedDirectoryDTO = oldDirectoryDTO.convertDirectoryEntityToDTO(directoryService.updateDirectory(
                id, oldDirectoryDTO.convertDirectoryDTOToDirectoryEntity(directoryDTO)));
        return ResponseEntity.ok(updatedDirectoryDTO);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        directoryService.deleteDirectoryById(id);
        return ResponseEntity.ok("delete calculation with id=" + id);
    }
}
