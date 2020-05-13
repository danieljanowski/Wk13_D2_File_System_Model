package com.codeclan.example.filesystem.controllers;

import com.codeclan.example.filesystem.models.Folder;
import com.codeclan.example.filesystem.respositories.FileRespository;
import com.codeclan.example.filesystem.respositories.FolderRespository;
import com.codeclan.example.filesystem.respositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.memory.LinearAllocBlock;

import java.util.List;

@RestController
public class FolderController {
    @Autowired
    private FileRespository fileRespository;
    @Autowired
    private FolderRespository folderRespository;
    @Autowired
    private UserRespository userRespository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        List<Folder> foundFolders = folderRespository.findAll();
        return new ResponseEntity<List<Folder>>(foundFolders, HttpStatus.OK);
    }

    @GetMapping(value = "/folder/{id}")
    public ResponseEntity getFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRespository.findById(id), HttpStatus.OK);
    }
}
