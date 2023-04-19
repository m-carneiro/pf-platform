package apps.progfort.platform.registry;

import org.springframework.stereotype.Service;

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

    public LastViewedCourseRegistry save(LastViewedCourseRegistryDTO lastViewedCourseRegistryDTO) {
        return lastViewedCourseRegistryRepository.save(
                lastViewedCourseRegistryFactory.create(lastViewedCourseRegistryDTO)
        );
    }

}
