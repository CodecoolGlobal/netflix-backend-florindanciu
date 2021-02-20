package com.florindanciu.videorecommendationservice;

import com.florindanciu.videorecommendationservice.model.VideoRecommendation;
import com.florindanciu.videorecommendationservice.repository.VideoRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoRecommendationServiceApplication {

	private final VideoRecommendationRepository repository;

	@Autowired
	public VideoRecommendationServiceApplication(VideoRecommendationRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(VideoRecommendationServiceApplication.class, args);
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
	public CommandLineRunner init() {
		return args -> {
			repository.saveAll(List.of(
					VideoRecommendation.builder()
							.videoId(1L)
							.rating(3)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sit enim idem caecus, debilis. Quis Aristidem non mortuum diligit? Sed fortuna fortis; Istam voluptatem perpetuam quis potest praestare sapienti?")
							.username("Bill Gates")
							.build(),

					VideoRecommendation.builder()
							.videoId(1L)
							.rating(4)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quare conare, quaeso. Quis est tam dissimile homini. Illud non continuo, ut aeque incontentae.")
							.username("Elon Musk")
							.build(),

					VideoRecommendation.builder()
							.videoId(2L)
							.rating(5)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. At enim sequor utilitatem. Haec quo modo conveniant, non sane intellego. Ad eas enim res ab Epicuro praecepta dantur. Quamquam te quidem video minime esse deterritum.")
							.username("Jeff Bezos")
							.build(),

					VideoRecommendation.builder()
							.videoId(2L)
							.rating(3)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ille enim occurrentia nescio quae comminiscebatur; Quamquam id quidem licebit iis existimare, qui legerint. Id est enim, de quo quaerimus. Haeret in salebra. Quid enim possumus hoc agere divinius? Duo Reges: constructio interrete.")
							.username("Tim Cook")
							.build(),

					VideoRecommendation.builder()
							.videoId(2L)
							.rating(1)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Bonum integritas corporis: misera debilitas. Quid censes in Latino fore? Sic enim censent, oportunitatis esse beate vivere. Recte, inquit, intellegis. Si longus, levis;")
							.username("Linus Sebastian")
							.build(),

					VideoRecommendation.builder()
							.videoId(4L)
							.rating(4)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nimis multa. Hoc simile tandem est? At multis se probavit. Ego vero isti, inquam, permitto.")
							.username("Mark Zuckerberg")
							.build(),

					VideoRecommendation.builder()
							.videoId(4L)
							.rating(5)
							.comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Dici enim nihil potest verius. Satis est ad hoc responsum. Ego vero isti, inquam, permitto. Nam de isto magna dissensio est. Sed tamen intellego quid velit. Duo Reges: constructio interrete.")
							.username("George Washington")
							.build()
			));
		};
	}
}
