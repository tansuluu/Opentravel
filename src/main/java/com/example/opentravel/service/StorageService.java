package com.example.opentravel.service;
import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Place;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    public static final Path rootApp = Paths.get("upload-dir");

    public static final Path avatar = Paths.get("up-avatar");

    public void store(MultipartFile file){
        try {
            Files.copy(file.getInputStream(), this.rootApp.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL! Such file already exist");
        }
    }
    public void init() {
        try {
            Files.createDirectory(rootApp);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
    public void saveAvatar(MultipartFile file){
        try {
            Files.copy(file.getInputStream(), this.avatar.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("FAIL! Such file already exist");
        }
    }
    public Resource loadAvatar(String filename) {
        try {
            Path file = avatar.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new RuntimeException("cannot load such avatar!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
    public Resource loadFile(String filename) {
        try {
            Path file = rootApp.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new RuntimeException("No such file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
    public Place preStore(MultipartFile f1, MultipartFile f2, MultipartFile f3, Place app){
        if(!f1.isEmpty() || f1==null){
            app.setPhoto1(f1.getOriginalFilename());
            store(f1);}
        else
            app.setPhoto1("tur.jpg");
        if(!f2.isEmpty()){
            app.setPhoto2(f2.getOriginalFilename());
            store(f2);}
        if(!f3.isEmpty()) {
            app.setPhoto3(f3.getOriginalFilename());
            store(f3);}
        return app;
    }


    public Blog preStore(MultipartFile f1, MultipartFile f2, MultipartFile f3, Blog app){
        if(!f1.isEmpty()){
            app.setPhoto1(f1.getOriginalFilename());
            store(f1);}
        else
            app.setPhoto1("blogging.jpg");
        if(!f2.isEmpty()){
            app.setPhoto2(f2.getOriginalFilename());
            store(f2);}
        if(!f3.isEmpty()) {
            app.setPhoto3(f3.getOriginalFilename());
            store(f3);}
        return app;
    }

}