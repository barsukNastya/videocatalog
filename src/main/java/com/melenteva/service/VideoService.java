package com.melenteva.service;

import com.melenteva.model.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {

    public void addVideo(Video video);

    public void updateVideo(Video video);

    public void removeVideo(int id);

    public Video getVideoById(int id);

    public List<Video> listVideo();

    public List<Video> searchlistVideo(String videoName, String videoAuthor, String videoURL);
}
