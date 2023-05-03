package apps.progfort.platform.video;


import io.soabase.recordbuilder.core.RecordBuilderFull;

@RecordBuilderFull
public record VideoUpload(
        String approach,
        String size
) {
}
