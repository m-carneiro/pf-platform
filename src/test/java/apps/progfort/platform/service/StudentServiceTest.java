package apps.progfort.platform.service;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.exceptions.ResourceNotFoundException;
import apps.progfort.platform.exceptions.SQLIntegrityViolationException;
import apps.progfort.platform.registry.LastViewedCourseRegistry;
import apps.progfort.platform.students.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.springframework.dao.EmptyResultDataAccessException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static apps.progfort.platform.StaticMocks.STUDENT_ID;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentsRepository studentRepository;

    @Mock
    private StudentFactory studentFactory;

    @InjectMocks
    private StudentsService studentService;

    private Students students;
    private StudentDTO studentsDTO;
    private LastViewedCourseRegistry lastViewedCourseRegistry;

    @BeforeEach
    void setUp() {
        lastViewedCourseRegistry = new LastViewedCourseRegistry(
                "",
                new Students(),
                new Courses(),
                LocalDateTime.now()
        );
        students = new Students(
                STUDENT_ID,
                "John",
                "doe@gmail.com",
                emptyList(),
                lastViewedCourseRegistry
        );
        studentsDTO = new StudentDTO(
                STUDENT_ID,
                "John",
                "doe@gmail.com"
        );
    }

    @Test
    void getAllStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(students));

        List<Students> allStudents = studentService.getAllStudents();

        assertEquals(1, allStudents.size());
        assertEquals(students, allStudents.get(0));
    }

    @Test
    void getAStudentByID() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.of(students));

        Students student = studentService.getStudentById(STUDENT_ID);

        assertEquals(students, student);
    }

    @Test
    void getAStudentByID_notFound() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> studentService.getStudentById(STUDENT_ID)
        );
    }

    @Test
    void createStudent() {
        when(studentFactory.createStudent(studentsDTO)).thenReturn(students);
        when(studentRepository.save(students)).thenReturn(students);

        Students createdStudent = studentService.createStudent(studentsDTO);

        assertEquals(students, createdStudent);
    }

    @Test
    void updateStudent() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.of(students));
        when(studentFactory.createStudent(studentsDTO)).thenReturn(students);
        when(studentRepository.save(students)).thenReturn(students);

        Students updatedStudent = studentService.updateStudent(STUDENT_ID, studentsDTO);

        assertEquals(students, updatedStudent);
    }

    @Test
    void updateStudent_notFound() {
        when(studentRepository.findById(STUDENT_ID)).thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> studentService.updateStudent(STUDENT_ID, studentsDTO)
        );
    }

    @Test
    void deleteStudent() {
        studentService
                .deleteStudent(STUDENT_ID);

        verify(studentRepository, times(1)).deleteById(STUDENT_ID);
    }

    @Test
    void save() {
        when(studentRepository.save(students)).thenReturn(students);

        studentService.save(students);

        verify(studentRepository, times(1)).save(students);
    }
}
