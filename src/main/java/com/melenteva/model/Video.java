package com.melenteva.model;

/**
 * Created by User on 18.02.2017.
 */
public class Video {

    private int Id;
    private String videoName;
    private String videoAuthor;
    private String videoURL;

    public Video()
    {
        this.videoName = "";
        this.videoAuthor = "";
        this.videoURL = "";

    }
    public Video(String videoName,String videoAuthor, String videoURL)
    {
        this.videoName = videoName;
        this.videoAuthor = videoAuthor;
        this.videoURL = videoURL;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoAuthor() {
        return videoAuthor;
    }

    public void setVideoAuthor(String videoAuthor) {
        this.videoAuthor = videoAuthor;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
