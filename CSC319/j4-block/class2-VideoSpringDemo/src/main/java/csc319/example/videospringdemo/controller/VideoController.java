package csc319.example.videospringdemo.controller;

import csc319.example.videospringdemo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller // Tell spring that this class is a controller that should be handled HTTP requests from the dispatcher
@RequestMapping("/video") // Map the request from /video to this controller
public class VideoController {

    private final VideoRepository videoRepository;

    @Autowired // Tell Spring to do dependency injection to the constructor
    public VideoController(@Qualifier("videoModelNoDuplicate") VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostMapping()
    @ResponseBody
    public boolean addVideo(@RequestBody Video v) {
        return videoRepository.addVideo(v);
    }

    @GetMapping
    @ResponseBody
    public Collection<Video> getVideos(@RequestParam(value = "title", required = false) String title) {
        if (title == null || title.length() == 0) {
            return videoRepository.getVideos();
        }
        return videoRepository.findByTitle(title);
    }

}
