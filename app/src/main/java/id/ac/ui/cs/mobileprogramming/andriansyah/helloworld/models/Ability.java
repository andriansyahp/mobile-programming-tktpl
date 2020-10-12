package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ability implements Serializable {
    @SerializedName("ability")
    private AbilityDetail ability;
}
