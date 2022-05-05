package csc319.example.videospringdemo.repository;

import csc319.example.videospringdemo.controller.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component() // Tell Spring that this is a component in Spring application (Can be AutoWired)
public class VideoModel implements VideoRepository {
    private Set<Video> videos = Collections.newSetFromMap(new ConcurrentHashMap<Video, Boolean>());

    @Override
    public boolean addVideo(Video v) {
        return this.videos.add(v);
    }

    @Override
    public Collection<Video> getVideos() {
        return this.videos;
    }

    @Override
    public Collection<Video> findByTitle(String title) {
        return this.videos.stream()
                .filter(vid -> vid.getName().contains(title))
                .collect(Collectors.toList());
    }
}
