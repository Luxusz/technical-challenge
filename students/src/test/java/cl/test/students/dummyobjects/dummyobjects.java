package cl.test.students.dummyobjects;

import cl.test.students.dto.CourseDTO;
import cl.test.students.dto.StudentDTO;
import cl.test.students.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class dummyobjects {

    public static StudentDTO getStudentDTO(){
        return new StudentDTO(1, "Name 1", "LastName 1", "Email 1", 1);
    }

    public static Student getStudent(){
        return new Student(1, "Name 1", "LastName 1", "Email 1", 1);
    }

    public static List<StudentDTO> getStudentListDTO(){
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentDTOList.add(getStudentDTO());
        return studentDTOList;
    }

    public static List<Student> geStudentList(){
        List<Student> students = new ArrayList<>();
        students.add(getStudent());
        return students;
    }

    public static CourseDTO getCourseDTO(){
        return new CourseDTO(1, "Course 1", "Teacher 1");
    }
}
