package apps.progfort.platform.video;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record VideoUploadRequest(
        VideoUpload upload
) {
}