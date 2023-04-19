package apps.progfort.platform.courseClasses;

import apps.progfort.platform.courses.Courses;

import java.util.List;
import java.util.UUID;

public record CoursesWithStudents(
        String id,
        String studentId,
        List<Courses> courses,
        String message
) {

}

