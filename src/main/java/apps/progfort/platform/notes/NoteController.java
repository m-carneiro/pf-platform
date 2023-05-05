package apps.progfort.platform.notes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NotesService notesService;

    public NoteController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(
            @RequestBody NoteDTO noteDTO
    ) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{title}")
                .buildAndExpand(noteDTO.title())
                .toUri();

        return ResponseEntity.created(location).body(notesService.save(noteDTO));
    }

    @RequestMapping("/all/{studentId}")
    public ResponseEntity<List<Note>> getAllNotesFromAStudentBy(
            @PathVariable String studentId
    ) {
        return ResponseEntity.ok(notesService.getAllNotesFromAStudentBy(studentId));
    }
}
