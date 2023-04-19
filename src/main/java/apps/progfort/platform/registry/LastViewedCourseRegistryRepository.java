package apps.progfort.platform.registry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastViewedCourseRegistryRepository extends JpaRepository<LastViewedCourseRegistry, String> {
}
