package apps.progfort.platform.students;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.notes.Note;
import apps.progfort.platform.registry.LastViewedCourseRegistry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "students")
public class Students implements Serializable {

    @Id
    private String id;
    String name;
    String email;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id"
            )
    )
    @JsonIgnoreProperties("students")
    private List<Courses> courses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "last_viewed_course_registry_id",
            referencedColumnName = "id"
    )
    private LastViewedCourseRegistry lastViewedCourseRegistry;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "students_notes",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "note_id",
                    referencedColumnName = "id"
            )
    )
    @JsonIgnoreProperties("students")
    private List<Note> notes;
    public Students(
            String id,
            String name,
            String email,
            List<Courses> courses,
            LastViewedCourseRegistry lastViewedCourseRegistry,
            List<Note> notes
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = courses;
        this.lastViewedCourseRegistry = lastViewedCourseRegistry;
        this.notes = notes;
    }

    public Students() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public LastViewedCourseRegistry getLastViewedCourseRegistry() {
        return lastViewedCourseRegistry;
    }

    public void setLastViewedCourseRegistry(LastViewedCourseRegistry lastViewedCourseRegistry) {
        this.lastViewedCourseRegistry = lastViewedCourseRegistry;
    }
}
