package apps.progfort.platform.classes;

import apps.progfort.platform.courses.Courses;
import apps.progfort.platform.enums.Difficulties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    private String id;
    private String name;
    private String description;
    private String thumbnail;
    private String video;
    private Double duration;

    private Difficulties level;
    @ManyToOne()
    private Courses course;

    public Classes() {
    }

    public Classes(String id, Courses course) {
        this.id = id;
        this.course = course;
    }
}
