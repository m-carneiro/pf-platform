package apps.progfort.platform.notes;

import apps.progfort.platform.exceptions.SQLIntegrityViolationException;
import apps.progfort.platform.students.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static apps.progfort.platform.exceptions.ExceptionMessages.CANNOT_DELETE_NOTE_WITH_ID;

@Service
public class NotesService {

    private final NotesRepository notesRepository;
    private final NotesFactory notesFactory;
    private final StudentsService studentsService;

    public NotesService(
            NotesRepository notesRepository,
            NotesFactory notesFactory,
            StudentsService studentsService
    )
    {
        this.notesRepository = notesRepository;
        this.notesFactory = notesFactory;
        this.studentsService = studentsService;
    }

    public List<Note> findAll() {
        return notesRepository.findAll();
    }

    public Note save(NoteDTO noteDTO) {
        var student = studentsService.getStudentById(noteDTO.studentId());

        return notesRepository.save(notesFactory.createNote(noteDTO, student));
    }

    public void deleteById(String id) {
        try {
            notesRepository.deleteById(id);
        } catch (Exception e) {
            throw new SQLIntegrityViolationException(CANNOT_DELETE_NOTE_WITH_ID + id);
        }
    }

    public List<Note> getAllNotesFromAStudentBy(String studentId) {
        List<Note> notes = notesRepository.findAll();

        return notes.stream()
                .filter(note -> note.getStudents()
                        .stream()
                        .anyMatch(student -> student.getId().equals(studentId)))
                .collect(Collectors.toList());
    }
}