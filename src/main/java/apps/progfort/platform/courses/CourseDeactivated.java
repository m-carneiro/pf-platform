package apps.progfort.platform.courses;

public record CourseDeactivated(
        String courseId,
        boolean isActive,
        String message
) {
}
