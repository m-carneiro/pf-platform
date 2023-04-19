package apps.progfort.platform.registry;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.students.Students;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "last_view_registry")
public class LastViewedCourseRegistry {

    @Id
    private String id;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "lastViewedCourseRegistry"
    )
    private Students student;

    @OneToOne
    @JsonIgnoreProperties("lastViewedCourseRegistry")
    private Courses lastViewedCourse;

    private LocalDateTime lastViewedDate;

    public LastViewedCourseRegistry() {
    }

    public LastViewedCourseRegistry(
            String id,
            Students student,
            Courses lastViewedCourse,
            LocalDateTime lastViewedDate
    ) {
        this.id = id;
        this.student = student;
        this.lastViewedCourse = lastViewedCourse;
        this.lastViewedDate = lastViewedDate;
    }

    public String getId() {
        return id;
    }
    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getLastViewedCourse() {
        return lastViewedCourse;
    }

    public void setLastViewedCourse(Courses lastViewedCourse) {
        this.lastViewedCourse = lastViewedCourse;
    }

    public LocalDateTime getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(LocalDateTime lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }
}
