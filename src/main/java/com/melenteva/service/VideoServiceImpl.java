package com.melenteva.service;

import com.melenteva.mappers.VideoMapper;
import com.melenteva.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 18.02.2017.
 */

@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    @Transactional
    public void addVideo(Video video) {
        this.videoMapper.addVideo(video);
    }

    @Transactional
    public void updateVideo(Video video) {
        this.videoMapper.updateVideo(video);
    }


    @Transactional
    public void removeVideo(int id) {
        this.videoMapper.removeVideo(id);
    }


    @Transactional
    public Video getVideoById(int id) {
        return this.videoMapper.getVideoById(id);
    }


    @Transactional
    public List<Video> listVideo() {
        return this.videoMapper.listVideo();
    }

    @Transactional
    public List<Video> searchlistVideo(String videoName, String videoAuthor, String videoURL) {
        return this.videoMapper.searchlistVideo(videoName,videoAuthor, videoURL);
    }

}
