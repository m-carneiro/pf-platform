package apps.progfort.platform.notes;


import apps.progfort.platform.students.Students;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note implements Serializable {

    @Id
    private String id;
    private String title;
    @Column(length = 2048)
    private String content;
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "notes"
    )
    @JsonIgnoreProperties("notes")
    private List<Students> students;

    public Note() {
    }

    public Note(String id, String title, String content, List<Students> students) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
