package com.codeclan.example.fileFolderHW;

import com.codeclan.example.fileFolderHW.models.File;
import com.codeclan.example.fileFolderHW.models.Folder;
import com.codeclan.example.fileFolderHW.models.User;
import com.codeclan.example.fileFolderHW.repositories.FileRepository;
import com.codeclan.example.fileFolderHW.repositories.FolderRepository;
import com.codeclan.example.fileFolderHW.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileFolderHwApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createFolderAndUserThenSave(){
		User collin = new User("Collin Bull");
		userRepository.save(collin);

		Folder music = new Folder("Thrice", collin);
		folderRepository.save(music);
	}

	@Test
	public void createFolderAndFileThenSave(){
		User collin = new User("Collin Bull");
		userRepository.save(collin);
		Folder music = new Folder("Thrice", collin);
		folderRepository.save(music);

		File weight = new File("The_Weight", ".mp3", "1.2mb");
		fileRepository.save(weight);

		music.addFile(weight);
		weight.addFolder(music);
		fileRepository.save(weight);
	}

}
