package csc319.example.videospringdemo;

import csc319.example.videospringdemo.repository.VideoModel;
import csc319.example.videospringdemo.repository.VideoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = VideoRepository.class)
public class Class2VideoSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Class2VideoSpringDemoApplication.class, args);
    }
}
