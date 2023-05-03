package apps.progfort.platform.video.auth;

public record VimeoAuthResponse(
        String access_token,
        String token_type,
        String scope,
        VimeoApp app
) {
}