package com.florindanciu.videoservice;

import com.florindanciu.videoservice.model.Video;
import com.florindanciu.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoServiceApplication {

	private final VideoRepository videoRepository;

	@Autowired
	public VideoServiceApplication(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Video video1 = Video.builder()
					.name("DNA Helix Stunning Science Animation")
					.url("https://youtu.be/6KyLy9ood1M")
					.build();

			Video video2 = Video.builder()
					.name("Hong Kong at Nightfall")
					.url("https://youtu.be/1MMPlZuvEPs")
					.build();

			Video video3 = Video.builder()
					.name("Fireworks")
					.url("https://youtu.be/Hrc1WrC8ihE")
					.build();

			Video video4 = Video.builder()
					.name("Baking Cookies")
					.url("https://youtu.be/urTztjXoTIc")
					.build();

			videoRepository.saveAll(List.of(video1, video2, video3, video4));
		};
	}
}
