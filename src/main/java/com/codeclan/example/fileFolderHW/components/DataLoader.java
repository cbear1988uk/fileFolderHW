package com.codeclan.example.fileFolderHW.components;

import com.codeclan.example.fileFolderHW.models.File;
import com.codeclan.example.fileFolderHW.models.Folder;
import com.codeclan.example.fileFolderHW.models.User;
import com.codeclan.example.fileFolderHW.repositories.FileRepository;
import com.codeclan.example.fileFolderHW.repositories.FolderRepository;
import com.codeclan.example.fileFolderHW.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Collin Bull");
        userRepository.save(user1);
        User user2 = new User("Alex Merrill");
        userRepository.save(user2);

        Folder folder1 = new Folder("Movies", user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Music", user2);
        folderRepository.save(folder2);

        File file1 = new File("Interstellar", ".mp4", "1.7gb");
        fileRepository.save(file1);
        File file2 = new File("Despacito_2", ".mp3", "2mb");
        fileRepository.save(file2);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folderRepository.save(folder1);

        file2.addFolder(folder1);
        fileRepository.save(file2);
    }
}
