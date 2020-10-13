package id.ac.ui.cs.mobileprogramming.andriansyah.helloworld.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AbilityDetail implements Serializable {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
