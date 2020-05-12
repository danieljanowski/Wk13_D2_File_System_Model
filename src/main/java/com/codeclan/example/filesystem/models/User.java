package com.codeclan.example.filesystem.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "user")
    private List<Folder> folders;

    public User(List<Folder> folders) {
        this.folders = folders;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }
}
