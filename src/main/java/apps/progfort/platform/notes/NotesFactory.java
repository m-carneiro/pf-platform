package apps.progfort.platform.notes;

import apps.progfort.platform.students.Students;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class NotesFactory {
    public Note createNote(
            NoteDTO noteDTO,
            Students student
    ) {
        var id = UUID.randomUUID().toString();

        return new Note(
                id,
                noteDTO.title(),
                noteDTO.content(),
                List.of(student)
        );
    }
}
