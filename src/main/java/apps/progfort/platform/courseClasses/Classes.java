package apps.progfort.platform.courseClasses;

import apps.progfort.platform.courses.Courses;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "classes")
public class Classes implements Serializable {

    @Id
    private String id;
    private String name;
    private String lastView;
    private String thumbnail;

    @ManyToOne
    private Courses course;

    public Classes() {
    }

    public Classes(String id, String name, String lastView, String thumbnail, Courses course) {
        this.id = id;
        this.name = name;
        this.lastView = lastView;
        this.thumbnail = thumbnail;
        this.course = course;
    }
}
