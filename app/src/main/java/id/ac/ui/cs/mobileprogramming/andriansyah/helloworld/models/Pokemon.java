package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable {
    @SerializedName("abilities")
    private List<Ability> abilities;

    @SerializedName("base_experience")
    private int baseExp;

    @SerializedName("height")
    private int height;

    @SerializedName("name")
    private String name;

    @SerializedName("sprites")
    private Sprite sprites;

    @SerializedName("stats")
    private List<Stat> stat;

    @SerializedName("weight")
    private int weight;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getBaseExp() {
        return baseExp;
    }

    public void setBaseExp(int baseExp) {
        this.baseExp = baseExp;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStat() {
        return stat;
    }

    public void setStat(List<Stat> stat) {
        this.stat = stat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
