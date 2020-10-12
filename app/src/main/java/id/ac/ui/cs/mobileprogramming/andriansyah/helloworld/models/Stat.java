package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Stat implements Serializable {
    @SerializedName("base_stat")
    private int baseStat;

    @SerializedName("stat")
    private StatDetail statName;

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public StatDetail getStatName() {
        return statName;
    }

    public void setStatName(StatDetail statName) {
        this.statName = statName;
    }
}
