package config;

import controller.PostController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repository.PostRepository;
import repository.PostRepositoryStubImpl;
import service.PostService;

@Configuration
//@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
    public PostController postController() {
        return new PostController(postService());
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryStubImpl();
    }
}