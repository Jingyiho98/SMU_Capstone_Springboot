package com.otoro.model.ImageStorage;

import com.otoro.model.Security.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ImageStorage")
public class ImageStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_url")
    private String imageUrl;

    //many to one r/s with user
    @ManyToOne(fetch = FetchType.LAZY)
    private User imageUser;

    public ImageStorage() { }

    public ImageStorage(String imageType, String imageUrl) {
        this.imageType = imageType;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //r/s with user
    public User getImageUser() {
        return imageUser;
    }

    public void setImageUser(User imageUser) {
        this.imageUser = imageUser;
    }

    //override toString method to return Json of Game information
    @Override
    public String toString(){
        return "{ \"imageType\":\"" + imageType
                + "\", \"imageUrl\":\"" + imageUrl
                + "\"}";

    }
}
