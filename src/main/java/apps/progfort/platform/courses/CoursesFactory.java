package apps.progfort.platform.courses;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Component
public class CoursesFactory {

    public Courses createCourse(CoursesDTO coursesDTO) {
        Courses course = new Courses();

        course.setId(UUID.randomUUID().toString());
        course.setName(coursesDTO.getName());
        course.setDescription(coursesDTO.getDescription());
        course.setTags(coursesDTO.getTags());
        course.setLevel(coursesDTO.getLevel());
        course.setClasses(Collections.emptyList());
        course.setPrice(coursesDTO.getPrice());
        course.setIsActive(false);
        course.setCategory(coursesDTO.getCategory());
        course.setStudents(Collections.emptyList());
        course.setUpdatedAt(LocalDateTime.now().toString());

        return course;
    }
}
