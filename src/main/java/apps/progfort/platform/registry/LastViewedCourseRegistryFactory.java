package apps.progfort.platform.registry;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.courses.CoursesService;
import apps.progfort.platform.students.Students;
import apps.progfort.platform.students.StudentsService;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class LastViewedCourseRegistryFactory {

  private final StudentsService studentsService;
  private final CoursesService coursesService;

  public LastViewedCourseRegistryFactory(StudentsService studentsService,
                                         CoursesService coursesService) {
    this.studentsService = studentsService;
    this.coursesService = coursesService;
  }

  public LastViewedCourseRegistry
  create(LastViewedCourseRegistryDTO lastViewedCourseRegistryDTO) {
    Students student = studentsService.getStudentById(
        lastViewedCourseRegistryDTO.getStudentId());

    Courses course =
        coursesService.getCourse(lastViewedCourseRegistryDTO.getCourseId());

    return new LastViewedCourseRegistry(UUID.randomUUID().toString(), student,
                                        course, LocalDateTime.now());
  }
}
