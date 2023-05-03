package apps.progfort.platform.video;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VimeoClient {

    private final WebClient webClient;

    public VimeoClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getVideo(String id) {
        return webClient.get()
                .uri("/videos/{id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
