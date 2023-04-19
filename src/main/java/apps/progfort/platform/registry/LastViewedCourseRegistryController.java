package apps.progfort.platform.registry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/last-viewed")
public class LastViewedCourseRegistryController {
  private final LastViewedCourseRegistryService lastViewedCourseRegistryService;

  public LastViewedCourseRegistryController(
      LastViewedCourseRegistryService lastViewedCourseRegistryService) {
    this.lastViewedCourseRegistryService = lastViewedCourseRegistryService;
  }

  @PostMapping("/register")
  public ResponseEntity<LastViewedCourseRegistry>
  save(@RequestBody LastViewedCourseRegistryDTO lastViewedCourseRegistry) {
    return ResponseEntity.ok(
        lastViewedCourseRegistryService.save(lastViewedCourseRegistry));
  }
}
