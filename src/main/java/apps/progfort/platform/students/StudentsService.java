package apps.progfort.platform.students;

import static apps.progfort.platform.exceptions.ExceptionMessages.STUDENT_NOT_FOUND;

import apps.progfort.platform.exceptions.ResourceNotFoundException;
import apps.progfort.platform.exceptions.SQLIntegrityViolationException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

  private final StudentsRepository studentsRepository;
  private final StudentFactory studentFactory;

  public StudentsService(StudentsRepository studentsRepository,
                         StudentFactory studentFactory) {
    this.studentsRepository = studentsRepository;
    this.studentFactory = studentFactory;
  }

  public List<Students> getAllStudents() {
    return studentsRepository.findAll();
  }

  public Students getStudentById(String id) {
    return studentsRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(STUDENT_NOT_FOUND));
  }

  public Students createStudent(StudentDTO student) {
    Students students = studentFactory.createStudent(student);
    return studentsRepository.save(students);
  }

  public Students updateStudent(String id, StudentDTO studentDTO) {
    Students student = studentsRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(STUDENT_NOT_FOUND));

    return updateAllData(student, studentDTO);
  }

  private Students updateAllData(Students student, StudentDTO studentDTO) {
    Students newStudent = studentFactory.createStudent(studentDTO);

    student.setId(newStudent.getId());
    student.setName(newStudent.getName());
    student.setEmail(newStudent.getEmail());
    student.setCourses(newStudent.getCourses());

    return studentsRepository.save(student);
  }

  public void deleteStudent(String id) {
    try {
      studentsRepository.deleteById(id);
    } catch (Exception e) {
      throw new SQLIntegrityViolationException(STUDENT_NOT_FOUND);
    }
  }

  public void save(Students student) { studentsRepository.save(student); }
}
