package apps.progfort.platform.courses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoursesController.class);
    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getAllCourses() {
        LOGGER.
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<Courses> addCourse(@RequestBody CoursesDAO coursesDAO) {
        Courses course = coursesService.addCourse(coursesDAO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getId())
                .toUri();

        return ResponseEntity.created(location).body(course);
    }
}
