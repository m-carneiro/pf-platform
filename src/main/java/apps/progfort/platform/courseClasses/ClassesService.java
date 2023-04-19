package apps.progfort.platform.courseClasses;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.courses.CoursesService;
import apps.progfort.platform.registry.LastViewedCourseRegistryService;
import apps.progfort.platform.students.Students;
import apps.progfort.platform.students.StudentsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static apps.progfort.platform.courses.CoursesMessages.COURSE_ADDED_SUCCESSFULLY;
import static apps.progfort.platform.exceptions.ExceptionMessages.COURSE_IS_NOT_ACTIVE;
import static apps.progfort.platform.exceptions.ExceptionMessages.COURSE_NOT_ADDED;

@Service
public class ClassesService {
    private final StudentsService studentsService;
    private final CoursesService coursesService;
    private final LastViewedCourseRegistryService lastViewedCourseRegistryService;

    public ClassesService(
            StudentsService studentsService,
            CoursesService coursesService,
            LastViewedCourseRegistryService lastViewedCourseRegistryService
    ) {
        this.studentsService = studentsService;
        this.coursesService = coursesService;
        this.lastViewedCourseRegistryService = lastViewedCourseRegistryService;
    }

    public CoursesWithStudents enrollStudent(String studentId, String courseId) {
        Students student = studentsService.getStudentById(studentId);
        Courses course = coursesService.getCourse(courseId);

        if (course.getIsActive()) {
            student.getCourses().add(course);
            course.getStudents().add(student);

            course.setUpdatedAt(LocalDateTime.now().toString());
            lastViewedCourseRegistryService.addLastViewRegistry(student);

            studentsService.save(student);
            coursesService.save(course);
        } else {
            return new CoursesWithStudents(
                    COURSE_NOT_ADDED,
                    student.getId(),
                    student.getCourses(),
                    COURSE_IS_NOT_ACTIVE
            );
        }

        return new CoursesWithStudents(
                UUID.randomUUID().toString(),
                student.getId(),
                student.getCourses(),
                COURSE_ADDED_SUCCESSFULLY
        );
    }

    public List<Courses> getAllMyCourses(String studentId) {
        return studentsService.getStudentById(studentId).getCourses();
    }
}
