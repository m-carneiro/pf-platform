package apps.progfort.platform.notes;

import apps.progfort.platform.exceptions.SQLIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static apps.progfort.platform.exceptions.ExceptionMessages.CANNOT_DELETE_NOTE_WITH_ID;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Note> findAll() {
        return notesRepository.findAll();
    }

    public Note save(Note notes) {
        return notesRepository.save(notes);
    }

    public void deleteById(String id) {

        try {
            notesRepository.deleteById(id);
        } catch (Exception e) {
            throw new SQLIntegrityViolationException(CANNOT_DELETE_NOTE_WITH_ID + id);

        }
    }
}
