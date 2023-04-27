package apps.progfort.platform.notes;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteController {

  private final NotesService notesService;

  public NoteController(NotesService notesService) {
    this.notesService = notesService;
  }

  @RequestMapping("/all/{studentId}")
  public ResponseEntity<List<Note>>
  getAllNotesFromAStudentBy(@PathVariable String studentId) {
    return ResponseEntity.ok(notesService.getAllNotesFromAStudentBy(studentId));
  }
}
