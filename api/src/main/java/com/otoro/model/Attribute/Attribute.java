package com.otoro.model.Attribute;

import com.otoro.model.Story.Story;

import javax.persistence.*;

@Entity
@Table(name = "attribute_info")
public class Attribute {

    @Id
    @GeneratedValue
    @Column(name = "attribute_id")
    private Long attributeId;

    @Column(name = "attribute_name")
    private String attributeName;

    @Column(name = "attributeImage")
    private String attributeImage;

    @Column(name = "winning_score")
    private Integer winningScore;

    @Column(name = "attribute_description")
    private String attributeDescription;

    //many to one r/s with story
    @ManyToOne(fetch = FetchType.LAZY)
    private Story storya;

    public Attribute() {
    }

    public Attribute(String attributeName, String attributeImage, Integer winningScore, String attributeDescription) {
        this.attributeName = attributeName;
        this.attributeImage = attributeImage;
        this.winningScore = winningScore;
        this.attributeDescription = attributeDescription;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeImage() {
        return attributeImage;
    }

    public void setAttributeImage(String attributeImage) {
        this.attributeImage = attributeImage;
    }

    public Integer getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(Integer winningScore) {
        this.winningScore = winningScore;
    }

    //r/s with story

    public Story getStorya() {
        return storya;
    }

    public void setStorya(Story storya) {
        this.storya = storya;
    }

    @Override
    public String toString(){

        return "{ \"attributeName\":\"" + attributeName
                + "\", \"attributeImage\":\"" + attributeImage
                + "\", \"winningScore\":" + winningScore
                + ", \"attributeDescription\":\"" + attributeDescription
                + "\"}";
    }
}
