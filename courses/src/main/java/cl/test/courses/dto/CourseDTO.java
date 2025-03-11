package cl.test.courses.dto;

public class CourseDTO {
    private Long id;
    private String nameCourse;
    private String teacherCourse;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String nameCourse, String teacherCourse) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.teacherCourse = teacherCourse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(String teacherCourse) {
        this.teacherCourse = teacherCourse;
    }
}
