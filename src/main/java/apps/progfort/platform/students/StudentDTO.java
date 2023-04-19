package apps.progfort.platform.students;

public class StudentDTO {
    private String name;
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(String id, String name, String email) {
        this.name = name;
        this.email = email;
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
}
