package apps.progfort.platform.courses;

import apps.progfort.platform.courseClasses.Classes;
import apps.progfort.platform.enums.Dificulties;
import apps.progfort.platform.students.Students;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;

    @ElementCollection
    private List<String> tags;

    private Dificulties level;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "course"
    )
    private List<Classes> classes;
    private Double price;
    private Boolean isActive;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "courses"
    )
    private List<Students> students;

    public Courses() {
    }

    public Courses(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Courses(String id,
                   String name,
                   String description,
                   List<String> tags,
                   Dificulties level,
                   List<Classes> classes,
                   Double price,
                   Boolean isActive,
                   List<Students> students
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.level = level;
        this.classes = classes;
        this.price = price;
        this.isActive = isActive;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }

    public Dificulties getLevel() {
        return level;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setLevel(Dificulties level) {
        this.level = level;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
