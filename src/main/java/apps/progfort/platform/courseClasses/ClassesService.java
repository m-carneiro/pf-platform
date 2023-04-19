package apps.progfort.platform.courseClasses;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.courses.CoursesService;
import apps.progfort.platform.students.Students;
import apps.progfort.platform.students.StudentsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static apps.progfort.platform.courses.CoursesMessages.COURSE_ADDED_SUCCESSFULLY;

@Service
public class ClassesService {
    private final StudentsService studentsService;
    private final CoursesService coursesService;

    public ClassesService(
            StudentsService studentsService,
            CoursesService coursesService
    ) {
        this.studentsService = studentsService;
        this.coursesService = coursesService;
    }

    public CoursesWithStudents enrollStudent(String studentId, String courseId) {
        Students student = studentsService.getStudentById(studentId);
        Courses course = coursesService.getCourse(courseId);

        student.getCourses().add(course);
        course.getStudents().add(student);

        studentsService.save(student);
        coursesService.save(course);

        return new CoursesWithStudents(
                UUID.randomUUID().toString(),
                student.getId(),
                student.getCourses(),
                COURSE_ADDED_SUCCESSFULLY
        );
    }
}
