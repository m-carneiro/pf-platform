package apps.progfort.platform.courseClasses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/classes")
public class ClassesController {
    private final ClassesService classesService;

    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @PostMapping("/enroll/{studentId}/{courseId}")
    public ResponseEntity<CoursesWithStudents> enrollStudent(
           @PathVariable String studentId,
           @PathVariable String courseId
    ) {
        return ResponseEntity.ok(classesService.enrollStudent(studentId, courseId));
    }
}
