package com.codeclan.example.fileFolderHW.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    setting primary key
    private Long id;
//    Long allows a very large set of integers, whereas int has a limit

    @Column(name = "name")
    private String name;

    @Column(name = "ext")
    private String ext;

    @Column(name = "size")
    private String size;

    @JsonIgnore
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "folder_files",
            joinColumns = {@JoinColumn(name = "file_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="folder_id", nullable = false, updatable = false)}
    )
    private List<Folder> folders;

    public File(String name, String ext, String size){
        this.name = name;
        this.ext = ext;
        this.size = size;
        this.folders = new ArrayList<Folder>();
    }

    public File(){}
//    default constructor

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExt() {
        return ext;
    }

    public String getSize() {
        return size;
    }

    public List<Folder> getFolders() {
        return folders;
    }
}
