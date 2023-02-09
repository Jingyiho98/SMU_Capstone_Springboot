package com.otoro.model.Consequences;

import com.otoro.model.Option.Option;
import com.otoro.model.Scene.Scene;
import com.otoro.model.Story.Story;

import javax.persistence.*;

@Entity
@Table(name = "consequences_info")
public class Consequences {

    @Id
    @GeneratedValue
    @Column(name = "consequence_id")
    private Long consequenceId;

    @Column(name = "attribute_name")
    private String attributeName;

    @Column(name = "effect")
    private Integer effect;


    //many to one r/s with option
    @ManyToOne(fetch = FetchType.LAZY)
    private Option option;

    public Consequences() {
    }

    public Consequences( String attributeName, Integer effect) {
        this.attributeName = attributeName;
        this.effect = effect;
    }

    public Long getConsequenceId() {
        return consequenceId;
    }

    public void setConsequenceId(Long consequenceId) {
        this.consequenceId = consequenceId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Integer getEffect() {
        return effect;
    }

    public void setEffect(Integer effect) {
        this.effect = effect;
    }

    // r/s with options

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString(){
        return "{ \"attributeName\":\"" + attributeName
                + "\", \"effect\":\"" + effect
                + "\"}";
    }
}
