package com.otoro.services;

import com.otoro.dao.ImageStorage.ImageStorageDAO;
import com.otoro.dao.Teacher.TeacherDAO;
import com.otoro.model.ImageStorage.ImageStorage;
import com.otoro.model.Security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ImageStorageService {
    private final ImageStorageDAO imageStorageDAO;

    //inject TeacherDataAccessService
    @Autowired
    public ImageStorageService(@Qualifier("postgresImageStorage") ImageStorageDAO imageStorageDAO) {
        this.imageStorageDAO = imageStorageDAO;
    }

    public List<ImageStorage> selectAllImages(User user){
        return imageStorageDAO.selectAllImages(user);
    }

    public ImageStorage postImage(ImageStorage imageStorage){
        return imageStorageDAO.postImage(imageStorage);
    }

    public void deleteImage(ImageStorage imageToDelete){
        imageStorageDAO.deleteImage(imageToDelete);
    }

    public ImageStorage getImageByUrl(String imageUrl){
        return imageStorageDAO.getImageByUrl(imageUrl);
    }


}
