package apps.progfort.platform.video.auth;

import apps.progfort.platform.video.VideoUploadRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;
import java.util.HashMap;

@Service
public class VimeoAuthClient {

    @Value("${vimeo.auth.url}")
    private String AUTH_ENDPOINT;

    @Value("${vimeo.auth.accept-media-type}")
    private String VIMEO_MEDIA_TYPE;

    @Value("${vimeo.auth.client-id}")
    private String CLIENT_ID;

    @Value("${vimeo.auth.client-secret}")
    private String CLIENT_SECRET;

    private final WebClient webClient;

    public VimeoAuthClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getAccessToken() {
        VimeoAuthResponse response = webClient.post()
                .uri(AUTH_ENDPOINT)
                .header("Authorization", basicAuth())
                .body(BodyInserters.fromValue(requestBody()))
                //  .body(Mono.just(requestBody()), HashMap.class) <- TODO(TEST THIS)
                .accept(MediaType.valueOf(VIMEO_MEDIA_TYPE))
                .retrieve()
                .bodyToMono(VimeoAuthResponse.class)
                .block();

        assert response != null;
        return response.access_token();
    }


    private String basicAuth() {
        String auth = CLIENT_ID + ":" + CLIENT_SECRET;
        return "Basic " + Base64.getEncoder().encodeToString((auth).getBytes());
    }

    private HashMap<String, String> requestBody() {
        HashMap<String, String> body = new HashMap<>();
        body.put("grant_type", "client_credentials");
        body.put("scope", "public");
        return body;
    }
}
