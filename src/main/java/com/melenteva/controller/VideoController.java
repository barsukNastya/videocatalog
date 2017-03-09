package com.melenteva.controller;

import com.google.gson.Gson;
import com.melenteva.model.User;
import com.melenteva.model.Video;
import com.melenteva.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("video")
public class VideoController {

    @Autowired
    private VideoService videoService;



    @RequestMapping(value = "/videos/add", method = RequestMethod.POST)
    public String addVideo(@ModelAttribute("video") Video video){
        if(video.getId() == 0){
            this.videoService.addVideo(video);
        }else {
            this.videoService.updateVideo(video);
        }

        return "redirect:/videos";
    }


    @RequestMapping(value = "videos", method = RequestMethod.GET)
    public String listVideo(@RequestParam(value = "videoName", required = false, defaultValue = "") String name,
                            @RequestParam(value = "videoAuthor", required = false, defaultValue = "") String author,
                            @RequestParam(value = "videoURL", required = false, defaultValue = "") String URL,
                            Model model,  HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session!=null) {

            model.addAttribute("session", session);
            model.addAttribute("video", new Video());
            model.addAttribute("sVideo", new Video());

            name = "%" + name + "%";
            author = "%" + author + "%";
            URL = "%" + URL + "%";

            List<Video> videoList = this.videoService.searchlistVideo(name, author, URL);

            model.addAttribute("listVideo", videoList);
            model.addAttribute("isAdmin", session.getAttribute("isAdmin"));

            return "videos";
        }
        else{
            return "redirect:/login";
        }
    }



    @RequestMapping("/remove/{id}")
    public String removeVideo(@PathVariable(value = "id") int id, HttpServletResponse response) throws IOException {
        this.videoService.removeVideo(id);
        return "redirect:/videos";
    }

    @RequestMapping("/edit/{id}")
    public String editVideo(@PathVariable("id") int id, Model model){
        model.addAttribute("video", this.videoService.getVideoById(id));
        model.addAttribute("listVideo", this.videoService.listVideo());

        return "videos";
    }

    @RequestMapping("videodata/{id}")
    public String videoData(@PathVariable("id") int id, Model model){
        model.addAttribute("video", this.videoService.getVideoById(id));

        return "videodata";
    }

}
