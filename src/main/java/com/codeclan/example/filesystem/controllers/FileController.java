package com.codeclan.example.filesystem.controllers;

import com.codeclan.example.filesystem.models.File;
import com.codeclan.example.filesystem.respositories.FileRespository;
import com.codeclan.example.filesystem.respositories.FolderRespository;
import com.codeclan.example.filesystem.respositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileRespository fileRespository;
    @Autowired
    private FolderRespository folderRespository;
    @Autowired
    private UserRespository userRespository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        List<File> foundFiles = fileRespository.findAll();
        return new ResponseEntity<List<File>>(foundFiles, HttpStatus.OK);
    }

    @GetMapping(value = "/file/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity<> (fileRespository.findById(id), HttpStatus.OK);
    }
}
