package csc319.class4.videodemojpa.controller;

import com.google.common.collect.Lists;
import csc319.class4.videodemojpa.repository.Video;
import csc319.class4.videodemojpa.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/video")
public class VideoController {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @PostMapping
    public boolean addVideo(@RequestBody Video video) {
        videoRepository.save(video);
        return true;
    }

    @GetMapping
    public Collection<Video> getVideoList() {
//        return Lists.newArrayList(videoRepository.findAll());
        return videoRepository.findAll();
    }
}
