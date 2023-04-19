package apps.progfort.platform.students;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentsService.getStudentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Students>> getAllStudents() {
        return ResponseEntity.ok(studentsService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<Students> createStudent(
            @RequestBody StudentDTO studentDTO
    ) {
        Students student = studentsService.createStudent(studentDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(location).body(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Students> updateStudent(
            @PathVariable String id,
            @RequestBody StudentDTO studentDTO
    ) {
        Students student = studentsService.updateStudent(id, studentDTO);

        return ResponseEntity.ok().body(student);
    }
}
