package com.example.user.cinema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ModelCinema {
    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }
}

class Result {
    @SerializedName("unmain")
    @Expose
    private ArrayList<Unmain> unmain;

    public ArrayList<Unmain> getUnmain() {
        return unmain;
    }

}

class Unmain {
    public Unmain(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("vote")
    @Expose
    private String vote;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private String address;

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

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getVote() {
        return vote;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

}
