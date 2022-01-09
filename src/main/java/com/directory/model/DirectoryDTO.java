package com.directory.model;

import com.directory.domain.entity.DirectoryEntity;

public class DirectoryDTO {
    private int id;
    private String name;
    private String shortName;

    public DirectoryDTO(){
    }

    public DirectoryDTO(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public DirectoryDTO convertDirectoryEntityToDTO(DirectoryEntity directory){
        return  new DirectoryDTO(
            directory.getId(),
                directory.getName(),
                directory.getShortName()
        );
    }

    public DirectoryEntity convertDirectoryDTOToDirectoryEntity(DirectoryDTO directoryDTO){
        return  new DirectoryEntity(
                directoryDTO.getId(),
                directoryDTO.getName(),
                directoryDTO.getShortName()
        );
    }
}
