package apps.progfort.platform.video;

import apps.progfort.platform.video.auth.VimeoAuthClient;
import apps.progfort.platform.video.auth.VimeoAuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vimeo")
public class VimeoController {

    private final VimeoAuthClient vimeoAuthClient;
    private final VimeoUploadClient vimeoUploadClient;

    public VimeoController(VimeoAuthClient vimeoAuthClient, VimeoUploadClient vimeoUploadClient) {
        this.vimeoAuthClient = vimeoAuthClient;
        this.vimeoUploadClient = vimeoUploadClient;
    }

    @GetMapping("/auth")
    public ResponseEntity<String> getAccessToken() {
        return ResponseEntity.ok(vimeoAuthClient.getAccessToken());
    }

    @GetMapping("/upload")
    public ResponseEntity<String> createVideo() {
        return ResponseEntity.ok(vimeoUploadClient.createVideo());
    }
}
