package apps.progfort.platform.registry;

public class LastViewedCourseRegistryDTO {
  private String studentId;
  private String courseId;

  public LastViewedCourseRegistryDTO() {}

  public LastViewedCourseRegistryDTO(String studentId, String courseId) {
    this.studentId = studentId;
    this.courseId = courseId;
  }

  public String getStudentId() { return studentId; }

  public void setStudentId(String studentId) { this.studentId = studentId; }

  public String getCourseId() { return courseId; }

  public void setCourseId(String courseId) { this.courseId = courseId; }
}
