package com.codeclan.example.filesystem.controllers;

import com.codeclan.example.filesystem.models.User;
import com.codeclan.example.filesystem.respositories.FileRespository;
import com.codeclan.example.filesystem.respositories.FolderRespository;
import com.codeclan.example.filesystem.respositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private FileRespository fileRespository;
    @Autowired
    private FolderRespository folderRespository;
    @Autowired
    private UserRespository userRespository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> foundUsers = userRespository.findAll();
        return new ResponseEntity<List<User>>(foundUsers, HttpStatus.OK);
    }
}
