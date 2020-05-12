package com.codeclan.example.filesystem.respositories;

import com.codeclan.example.filesystem.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRespository extends JpaRepository<Folder, Long> {
}
