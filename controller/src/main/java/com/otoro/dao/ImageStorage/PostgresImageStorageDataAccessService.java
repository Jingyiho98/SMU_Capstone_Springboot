package com.otoro.dao.ImageStorage;


import com.otoro.model.ImageStorage.ImageStorage;
import com.otoro.model.Security.User;
import com.otoro.model.Teacher.Teacher;
import com.otoro.repositories.GameCode.GameCodeRepository;
import com.otoro.repositories.ImageStorage.ImageStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgresImageStorage")
public class PostgresImageStorageDataAccessService implements ImageStorageDAO {

    private ImageStorageRepository imageStorageRepository;

    @Autowired
    public PostgresImageStorageDataAccessService(ImageStorageRepository imageStorageRepository) {
        this.imageStorageRepository = imageStorageRepository;
    }

    @Override
    public List<ImageStorage> selectAllImages(User user) {
        return imageStorageRepository.findImageStoragesByImageUser(user);
    }

    @Override
    public ImageStorage postImage(ImageStorage imageStorage) {
        return imageStorageRepository.save(imageStorage);
    }

    @Override
    public void deleteImage(ImageStorage imageToDelete) { imageStorageRepository.delete(imageToDelete); }

    @Override
    public ImageStorage getImageByUrl(String imageUrl){
        return imageStorageRepository.findImageStorageByImageUrl(imageUrl);
    }
}
