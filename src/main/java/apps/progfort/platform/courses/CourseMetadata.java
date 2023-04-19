package apps.progfort.platform.courses;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_metadata")
public class CourseMetadata {

  @Id private String id;
  private String thumbnail;

  @OneToOne(mappedBy = "metadata") private Courses courses;

  public CourseMetadata() {}

  public CourseMetadata(String thumbnail) { this.thumbnail = thumbnail; }

  public String getThumbnail() { return thumbnail; }

  public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }
}
