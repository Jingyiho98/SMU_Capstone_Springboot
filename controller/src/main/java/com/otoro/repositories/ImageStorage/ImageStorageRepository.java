package com.otoro.repositories.ImageStorage;

import com.otoro.model.ImageStorage.ImageStorage;
import com.otoro.model.Security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageStorageRepository extends CrudRepository<ImageStorage,Long > {
    List<ImageStorage> findImageStoragesByImageUser(User user);
    ImageStorage findImageStorageByImageUrl(String imageUrl);

}
