package apps.progfort.platform.courses;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;

@Component
public class CoursesFactory {

    public Courses createCourse(CoursesDAO coursesDAO) {
        Courses course = new Courses();

        course.setId(UUID.randomUUID().toString());
        course.setName(coursesDAO.getName());
        course.setDescription(coursesDAO.getDescription());
        course.setTags(coursesDAO.getTags());
        course.setLevel(coursesDAO.getLevel());
        course.setClasses(Collections.emptyList());
        course.setPrice(coursesDAO.getPrice());
        course.setIsActive(true);
        course.setStudents(Collections.emptyList());

        return course;
    }
}
