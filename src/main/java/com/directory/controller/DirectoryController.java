package com.directory.controller;


import com.directory.domain.entity.DirectoryEntity;
import com.directory.model.DirectoryDTO;
import com.directory.service.api.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/directories")
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;

    @GetMapping
    public List<DirectoryDTO> getAllDirectories() {
        List<DirectoryEntity> listOfDirectories = directoryService.getAll();
        List<DirectoryDTO> listOfDirectoryDTO = new ArrayList<>();
        for (DirectoryEntity entity : listOfDirectories) {
            listOfDirectoryDTO.add(DirectoryDTO.convertDirectoryEntityToDTO(entity));
        }
        return listOfDirectoryDTO;
    }

    @GetMapping(value = "/{id}")
    public DirectoryDTO getById(@PathVariable int id) {
        return DirectoryDTO.convertDirectoryEntityToDTO(directoryService.getDirectoryById(id));
    }

    @PostMapping
    public ResponseEntity<DirectoryDTO> createDirectory(@RequestBody DirectoryDTO directoryDTO) {
        DirectoryEntity newDirectoryEntity = directoryService.createDirectory(
                directoryDTO.convertDirectoryDTOToDirectoryEntity());
        DirectoryDTO receivedDirectoryDTO = DirectoryDTO.convertDirectoryEntityToDTO(newDirectoryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(receivedDirectoryDTO);
    }

    @PutMapping(value = "/{id}")
    public DirectoryDTO editDirectory(@PathVariable int id, DirectoryDTO directoryDTO) {
        DirectoryEntity updatedEntity = directoryService.updateDirectory(id, directoryDTO.convertDirectoryDTOToDirectoryEntity());
        DirectoryDTO updatedDirectoryDTO = DirectoryDTO.convertDirectoryEntityToDTO(updatedEntity);
        return updatedDirectoryDTO;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteDirectory(@PathVariable int id) {
        directoryService.deleteDirectoryById(id);
        return ResponseEntity.ok("delete calculation with id=" + id);
    }
}
