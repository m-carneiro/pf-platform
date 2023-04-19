package apps.progfort.platform.registry;

import apps.progfort.platform.courseClasses.StudentRequest;
import apps.progfort.platform.students.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/last-viewed")
public class LastViewedCourseRegistryController {
    private final StudentsService studentsService;

    public LastViewedCourseRegistryController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public ResponseEntity<LastViewedCourseRegistry> save(
            @RequestBody StudentRequest student
            ) {
        return ResponseEntity.ok(
                studentsService
                        .getStudentById(student.id())
                        .getLastViewedCourseRegistry()
        );
    }
}