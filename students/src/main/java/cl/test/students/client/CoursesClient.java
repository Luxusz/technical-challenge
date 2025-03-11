package cl.test.students.client;

import cl.test.students.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CoursesClient {

    private final WebClient webClient;

    public CoursesClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<CourseDTO> getCourseById(@PathVariable("id") int id){
        return webClient.get()
                .uri("courses/{id}", id)
                .retrieve()
                .bodyToMono(CourseDTO.class);
    }
}
