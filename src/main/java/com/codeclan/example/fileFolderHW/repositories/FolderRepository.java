package com.codeclan.example.fileFolderHW.repositories;

import com.codeclan.example.fileFolderHW.models.Folder;
import com.codeclan.example.fileFolderHW.projections.EmbedUserForFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedUserForFolder.class)
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
