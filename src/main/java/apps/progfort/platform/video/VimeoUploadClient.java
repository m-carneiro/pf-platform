package apps.progfort.platform.video;

import apps.progfort.platform.video.auth.VimeoAuthClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.*;

@Component
public class VimeoUploadClient {

    @Value("${vimeo.auth.accept-media-type}")
    private String VIMEO_MEDIA_TYPE;

    @Value("${vimeo.videos-uri}")
    private String VIMEO_VIDEOS_URI;
    private final WebClient webClient;
    private final VimeoAuthClient vimeoAuthClient;

    public VimeoUploadClient(WebClient webClient, VimeoAuthClient vimeoAuthClient) {
        this.webClient = webClient;
        this.vimeoAuthClient = vimeoAuthClient;
    }

    public String createVideo() {
        return webClient.post()
                .uri("/me/tutorial")
                .body(BodyInserters.fromValue(requestBody()))
                .header(AUTHORIZATION, "bearer " + vimeoAuthClient.getAccessToken())
                .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(ACCEPT, VIMEO_MEDIA_TYPE)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private VideoUploadRequest requestBody() {
        return new VideoUploadRequest(new VideoUpload("tus", "1024"));
    }
}
