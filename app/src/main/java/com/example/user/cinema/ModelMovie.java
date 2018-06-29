package com.example.user.cinema;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelMovie {

    @SerializedName("result")
    @Expose
    private ArrayList<MovieResult> result;

    public ArrayList<MovieResult> getResult() {
        return result;
    }
}
class MovieResult {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("vote")
    @Expose
    private String vote;
    @SerializedName("count_vote")
    @Expose
    private String countVote;
    @SerializedName("countries")
    @Expose
    private String countries;
    @SerializedName("age_limit")
    @Expose
    private String ageLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public String getVote() {
        return vote;
    }

    public String getCountVote() {
        return countVote;
    }

    public String getCountries() {
        return countries;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

}

