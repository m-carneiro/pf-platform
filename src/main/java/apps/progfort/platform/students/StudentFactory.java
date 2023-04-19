package apps.progfort.platform.students;

import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Collections.emptyList;

@Component
public class StudentFactory {

    public Students createStudent(StudentDTO student) {
        Students students = new Students(
                UUID.randomUUID().toString(),
                student.getName(),
                student.getEmail(),
                emptyList(),
                null
                );

        return students;
    }
}
