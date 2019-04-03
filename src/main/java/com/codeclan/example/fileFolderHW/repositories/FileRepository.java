package com.codeclan.example.fileFolderHW.repositories;

import com.codeclan.example.fileFolderHW.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
