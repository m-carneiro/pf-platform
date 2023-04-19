package apps.progfort.platform.courses;

import apps.progfort.platform.courseClasses.ClassesService;
import apps.progfort.platform.courseClasses.StudentRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/my-courses")
public class MyCoursesController {
    private final ClassesService classesService;

    public MyCoursesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @GetMapping
    public List<Courses> getAllMyCourses(
            @RequestBody StudentRequest student
    ) {
        return classesService.getAllMyCourses(student.id());
    }
}
