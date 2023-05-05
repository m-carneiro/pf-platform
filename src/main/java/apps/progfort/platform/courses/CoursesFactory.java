package apps.progfort.platform.courses;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class CoursesFactory {

  public Courses createCourse(CoursesDTO coursesDTO) {
    Courses course = new Courses();

    course.setId(UUID.randomUUID().toString());
    course.setName(coursesDTO.name());
    course.setDescription(coursesDTO.description());
    course.setTags(coursesDTO.tags());
    course.setLevel(coursesDTO.level());
    course.setClasses(Collections.emptyList());
    course.setPrice(coursesDTO.price());
    course.setIsActive(false);
    course.setCategory(coursesDTO.category());
    course.setStudents(Collections.emptyList());
    course.setUpdatedAt(LocalDateTime.now().toString());

    return course;
  }
}
