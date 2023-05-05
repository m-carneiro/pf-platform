package apps.progfort.platform.notes;

import apps.progfort.platform.students.Students;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class NotesFactory {
  public Note createNote(NoteDTO noteDTO, Students student) {
    var id = UUID.randomUUID().toString();

    return new Note(id, noteDTO.title(), noteDTO.content(), List.of(student));
  }
}
