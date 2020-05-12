package com.codeclan.example.filesystem.respositories;

import com.codeclan.example.filesystem.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRespository extends JpaRepository<File, Long> {
}
