package apps.progfort.platform.courses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourse(@PathVariable String id) {
        return ResponseEntity.ok(coursesService.getCourse(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Courses>> getAllCourses() {
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<Courses> addCourse(@RequestBody CoursesDTO coursesDTO) {
        Courses course = coursesService.addCourse(coursesDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getId())
                .toUri();

        return ResponseEntity.created(location).body(course);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Courses> updateCourse(
            @PathVariable String id,
            @RequestBody CoursesDTO coursesDTO
    ) {
        Courses course = coursesService.updateCourse(id, coursesDTO);

        return ResponseEntity.ok().body(course);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<CourseActivated> activateCourse(@PathVariable String id) {
        return ResponseEntity.ok(coursesService.activateCourse(id));
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<CourseDeactivated> deactivateCourse(@PathVariable String id) {
        return ResponseEntity.ok(coursesService.deactivateCourse(id));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
