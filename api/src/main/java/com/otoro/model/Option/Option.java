package com.otoro.model.Option;

import com.otoro.model.Consequences.Consequences;
import com.otoro.model.GameCode.GameCode;
import com.otoro.model.Scene.Scene;
import com.otoro.model.Story.Story;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "option_info")
public class Option {
    @Id
    @GeneratedValue
    @Column(name = "optionID")
    private Long optionId;

    @Column(name = "optionName" , columnDefinition="TEXT")
    private String optionName;

    @Column(name = "impactScene" , columnDefinition="TEXT")
    private String impactScene;

    //many to one r/s with story
    @ManyToOne
//            (fetch = FetchType.LAZY)
    private Scene scene;

    //one to many r/s with consequences
    @OneToMany(
            mappedBy = "option",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Consequences> consequences = new ArrayList<>();

    public Option() {
    }

    public Option(String optionName, String impactScene) {
        this.optionName = optionName;
        this.impactScene = impactScene;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getImpactScene() { return impactScene; }

    public void setImpactScene(String impactScene) { this.impactScene = impactScene; }

    public List<Consequences> getConsequences() { return consequences; }

    public void setConsequences(List<Consequences> consequences) { this.consequences = consequences; }

    // r/s with scene

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    // r/s with consequences one to many
    public void addConsequence(Consequences consequence) {
        consequences.add(consequence);
        consequence.setOption(this);
    }

    public void removeConsequence(Consequences consequence) {
        consequences.remove(consequence);
        consequence.setOption(null);
    }

    @Override
    public String toString(){
        return "{ \"optionId\":\"" + optionId
                + "\", \"optionName\":\"" + optionName
                + "\", \"impactScene\":\"" + impactScene
                + "\", \"consequences\":" + consequences
                + "}";
    }
}
