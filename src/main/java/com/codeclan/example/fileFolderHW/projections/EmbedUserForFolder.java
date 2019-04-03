package com.codeclan.example.fileFolderHW.projections;

import com.codeclan.example.fileFolderHW.models.Folder;
import com.codeclan.example.fileFolderHW.models.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedUserForFolder", types = Folder.class)
public interface EmbedUserForFolder {
    String getTitle();
    User getUser();
}
