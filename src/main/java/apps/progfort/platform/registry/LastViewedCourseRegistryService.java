package apps.progfort.platform.registry;

import apps.progfort.platform.courses.CoursesService;
import apps.progfort.platform.students.Students;
import apps.progfort.platform.students.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LastViewedCourseRegistryService {
    private final LastViewedCourseRegistryRepository lastViewedCourseRegistryRepository;
    private final LastViewedCourseRegistryFactory lastViewedCourseRegistryFactory;

    public LastViewedCourseRegistryService(
            LastViewedCourseRegistryRepository lastViewedCourseRegistryRepository,
            LastViewedCourseRegistryFactory lastViewedCourseRegistryFactory
    ) {
        this.lastViewedCourseRegistryRepository = lastViewedCourseRegistryRepository;
        this.lastViewedCourseRegistryFactory = lastViewedCourseRegistryFactory;
    }

    public void addLastViewRegistry(Students student) {
        List<LastViewedCourseRegistryDTO> studentCourses = student.getCourses().stream()
                .map(course -> {
                    LastViewedCourseRegistryDTO lastViewedCourseRegistryDTO = new LastViewedCourseRegistryDTO();
                    lastViewedCourseRegistryDTO.setCourseId(course.getId());
                    lastViewedCourseRegistryDTO.setStudentId(student.getId());
                    return lastViewedCourseRegistryDTO;
                })
                .toList();

        studentCourses.forEach(this::save);
    }

    public LastViewedCourseRegistry save(LastViewedCourseRegistryDTO lastViewedCourseRegistryDTO) {
        return lastViewedCourseRegistryRepository.save(
                lastViewedCourseRegistryFactory.create(lastViewedCourseRegistryDTO)
        );
    }

}
