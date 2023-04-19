package apps.progfort.platform.students;

import static java.util.Collections.emptyList;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {

  public Students createStudent(StudentDTO student) {
    Students students =
        new Students(UUID.randomUUID().toString(), student.getName(),
                     student.getEmail(), emptyList(), null);

    return students;
  }
}
