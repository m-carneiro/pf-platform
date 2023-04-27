package apps.progfort.platform.notes;

import static apps.progfort.platform.exceptions.ExceptionMessages.CANNOT_DELETE_NOTE_WITH_ID;

import apps.progfort.platform.exceptions.SQLIntegrityViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class NotesService {

  private final NotesRepository notesRepository;

  public NotesService(NotesRepository notesRepository) {
    this.notesRepository = notesRepository;
  }

  public List<Note> findAll() { return notesRepository.findAll(); }

  public Note save(Note notes) { return notesRepository.save(notes); }

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
        .filter(note
                -> note.getStudents().stream().anyMatch(
                    student -> student.getId().equals(studentId)))
        .collect(Collectors.toList());
  }
}