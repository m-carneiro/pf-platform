package apps.progfort.platform.courses;

import apps.progfort.platform.classes.Classes;
import apps.progfort.platform.enums.Difficulties;
import apps.progfort.platform.registry.LastViewedCourseRegistry;
import apps.progfort.platform.students.Students;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private String category;

    @ElementCollection
    private List<String> tags;

    private Difficulties level;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "course"
    )
    private List<Classes> classes;
    private Double price;
    private Boolean isActive;

    private String updatedAt;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "courses"
    )
    @JsonIgnoreProperties("courses")
    private List<Students> students;

    @OneToOne
    private CourseMetadata metadata;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "lastViewedCourse"
    )
    @JsonIgnoreProperties("lastViewedCourse")
    private LastViewedCourseRegistry lastViewedCourseRegistry;


    public Courses() {
    }

    public Courses(
            String id,
            String name,
            String description,
            String category,
            List<String> tags,
            Difficulties level,
            List<Classes> classes,
            Double price,
            Boolean isActive,
            String updatedAt,
            List<Students> students,
            CourseMetadata metadata,
            LastViewedCourseRegistry lastViewedCourseRegistry
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.level = level;
        this.classes = classes;
        this.price = price;
        this.isActive = isActive;
        this.updatedAt = updatedAt;
        this.students = students;
        this.metadata = metadata;
        this.lastViewedCourseRegistry = lastViewedCourseRegistry;
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

    public Difficulties getLevel() {
        return level;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getIsActive() {
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

    public void setLevel(Difficulties level) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CourseMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CourseMetadata metadata) {
        this.metadata = metadata;
    }

    public LastViewedCourseRegistry getLastViewedCourseRegistry() {
        return lastViewedCourseRegistry;
    }

    public void setLastViewedCourseRegistry(LastViewedCourseRegistry lastViewedCourseRegistry) {
        this.lastViewedCourseRegistry = lastViewedCourseRegistry;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
