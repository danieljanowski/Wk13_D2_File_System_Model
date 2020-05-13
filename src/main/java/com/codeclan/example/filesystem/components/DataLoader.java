package com.codeclan.example.filesystem.components;

import com.codeclan.example.filesystem.models.File;
import com.codeclan.example.filesystem.models.Folder;
import com.codeclan.example.filesystem.models.User;
import com.codeclan.example.filesystem.respositories.FileRespository;
import com.codeclan.example.filesystem.respositories.FolderRespository;
import com.codeclan.example.filesystem.respositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FileRespository fileRespository;

    @Autowired
    private FolderRespository folderRespository;

    @Autowired
    private UserRespository userRespository;

    public void run(ApplicationArguments args){
        User daniel = new User("daniel");
        userRespository.save(daniel);
        User millie = new User("millie");
        userRespository.save(millie);

        Folder animals = new Folder("animals", daniel);
        folderRespository.save(animals);
        Folder vehicles = new Folder("vehicles", millie);
        folderRespository.save(vehicles);
        Folder spaceships = new Folder("spaceships", daniel);
        folderRespository.save(spaceships);
        Folder boats = new Folder("boats", millie);
        folderRespository.save(boats);

        File cat = new File("cat", "txt", 1024, animals);
        fileRespository.save(cat);
        File car = new File("car", "pdf", 2056, vehicles);
        fileRespository.save(car);
        File dog = new File("dog", "pdf", 3465, animals);
        fileRespository.save(dog);
        File truck = new File("truck", "pdf", 8723, vehicles);
        fileRespository.save(truck);
    }

}
