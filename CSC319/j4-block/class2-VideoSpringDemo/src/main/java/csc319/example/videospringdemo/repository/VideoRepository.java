package csc319.example.videospringdemo.repository;

import csc319.example.videospringdemo.controller.Video;

import java.util.Collection;

public interface VideoRepository {
    public boolean addVideo(Video v);
    public Collection<Video> getVideos();
    public Collection<Video> findByTitle(String title);
}
