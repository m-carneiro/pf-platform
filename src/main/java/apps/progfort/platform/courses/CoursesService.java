package apps.progfort.platform.courses;

import apps.progfort.platform.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    private final CoursesRepository coursesRepository;
    private final CoursesFactory coursesFactory;

    public CoursesService(
            CoursesRepository coursesRepository,
            CoursesFactory coursesFactory) {
        this.coursesRepository = coursesRepository;
        this.coursesFactory = coursesFactory;
    }

    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Courses getCourse(String id) {
        return coursesRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course not found")
        );
    }

    public Courses addCourse(CoursesDAO coursesDAO) {
        return coursesRepository.save(coursesFactory.createCourse(coursesDAO));
    }
}
