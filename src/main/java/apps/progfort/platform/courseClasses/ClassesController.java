package apps.progfort.platform.courseClasses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    private final ClassesService classesService;

    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @PostMapping("/enroll/{courseId}")
    public ResponseEntity<CoursesWithStudents> enrollStudent(
           @RequestBody StudentRequest student,
           @PathVariable String courseId
    ) {
        return ResponseEntity.ok(classesService.enrollStudent(student.id(), courseId));
    }
}
