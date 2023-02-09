package com.otoro.controllers;

import com.otoro.model.ImageStorage.ImageStorage;
import com.otoro.model.Security.User;
import com.otoro.services.ImageStorageService;
import com.otoro.services.Security.UserDetailsServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class ImageStorageController {

    @Autowired
    private ImageStorageService imageStorageService;

    @Autowired
    private UserDetailsServiceImpl userService;

    @GetMapping(value = "/getAllImages")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<ImageStorage>> imageGetAll(@RequestParam Integer userId ) {
        User thisUser = userService.getUserById(Long.valueOf(userId));

        if (imageStorageService.selectAllImages(thisUser)==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(imageStorageService.selectAllImages(thisUser)); }

    @PostMapping(value = "/postImage")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity postImage(@RequestBody String json) {
        JSONObject reqObj = new JSONObject(json);
        Integer userId =  reqObj.getInt("userId");
        String imageType = reqObj.getString("imageType");
        String imageUrl = reqObj.getString("imageUrl");

        if (imageStorageService.getImageByUrl(imageUrl) != null ){
            return ResponseEntity.badRequest().body("file name already exists, choose another name");
        }

        ImageStorage newImage = new ImageStorage(imageType,imageUrl);
        User thisUser = userService.getUserById(Long.valueOf(userId));
        newImage.setImageUser(thisUser);

        imageStorageService.postImage(newImage);

        return ResponseEntity.ok("Image successfully posted");
    }

    @DeleteMapping("/deleteImage")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity deleteImage(@RequestBody String json) {
        JSONObject reqObj = new JSONObject(json);
        Integer userId =  reqObj.getInt("userId");
        String imageUrl = reqObj.getString("imageUrl");

        ImageStorage imageToDelete = imageStorageService.getImageByUrl(imageUrl);
        User thisUser = userService.getUserById(Long.valueOf(userId));

        if (imageToDelete == null){
            ResponseEntity.badRequest().build();
        }

        thisUser.removeImage(imageToDelete);

        //update user
        userService.addUser(thisUser);

        return ResponseEntity.ok("Image successfully deleted");
    }



}
