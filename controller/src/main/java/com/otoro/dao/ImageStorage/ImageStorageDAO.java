package com.otoro.dao.ImageStorage;

import com.otoro.model.GameCode.GameCode;
import com.otoro.model.ImageStorage.ImageStorage;
import com.otoro.model.Security.User;

import java.util.List;

public interface ImageStorageDAO {
    List<ImageStorage> selectAllImages(User user);

    ImageStorage postImage(ImageStorage imageStorage);

    void deleteImage(ImageStorage imageToDelete);

    ImageStorage getImageByUrl(String imageUrl);


}
