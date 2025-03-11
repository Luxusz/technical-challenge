package cl.test.students.dto;

public class StudentDTO {

    private int id;
    private String name;
    private String lastName;
    private String mail;
    private int courseId;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, String lastName, String mail, int courseId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
