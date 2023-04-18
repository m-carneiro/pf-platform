package apps.progfort.platform.courses;

import static apps.progfort.platform.exceptions.ExceptionMessages.COURSE_NOT_DELETED;
import static apps.progfort.platform.exceptions.ExceptionMessages.COURSE_NOT_FOUND;

import apps.progfort.platform.exceptions.ResourceNotFoundException;
import apps.progfort.platform.exceptions.SQLIntegrityViolationException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {
  private final CoursesRepository coursesRepository;
  private final CoursesFactory coursesFactory;

  public CoursesService(CoursesRepository coursesRepository,
                        CoursesFactory coursesFactory) {
    this.coursesRepository = coursesRepository;
    this.coursesFactory = coursesFactory;
  }

  public List<Courses> getAllCourses() { return coursesRepository.findAll(); }

  public Courses getCourse(String id) {
    return coursesRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(COURSE_NOT_FOUND));
  }

  public Courses addCourse(CoursesDTO coursesDTO) {
    return coursesRepository.save(coursesFactory.createCourse(coursesDTO));
  }

  public void deleteCourse(String id) {
    try {
      coursesRepository.deleteById(id);
    } catch (Exception e) {
      throw new SQLIntegrityViolationException(COURSE_NOT_DELETED);
    }
  }

  public Courses activateCourse(String id) {
    Courses courses = coursesRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(COURSE_NOT_FOUND));

    courses.setIsActive(true);

    return coursesRepository.save(courses);
  }

  public Courses deactivateCourse(String id) {
    Courses courses = coursesRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(COURSE_NOT_FOUND));

    courses.setIsActive(false);

    return coursesRepository.save(courses);
  }

  public Courses updateCourse(String id, CoursesDTO coursesDTO) {
    Courses courses = coursesRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(COURSE_NOT_FOUND));

    return updateAllData(courses, coursesDTO);
  }

  private Courses updateAllData(Courses courses, CoursesDTO coursesDTO) {
    Courses newCourse = coursesFactory.createCourse(coursesDTO);

    courses.setId(newCourse.getId());
    courses.setName(newCourse.getName());
    courses.setDescription(newCourse.getDescription());
    courses.setTags(newCourse.getTags());
    courses.setLevel(newCourse.getLevel());
    courses.setClasses(newCourse.getClasses());
    courses.setPrice(newCourse.getPrice());
    courses.setIsActive(true);
    courses.setStudents(newCourse.getStudents());

    return coursesRepository.save(courses);
  }
}
