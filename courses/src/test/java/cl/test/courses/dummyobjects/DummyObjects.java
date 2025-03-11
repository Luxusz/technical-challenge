package cl.test.courses.dummyobjects;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class DummyObjects {

    public static CourseDTO getCourseDTO(){
        return new CourseDTO(1, "Course 1", "Teacher 1");
    }
    public static Course getCourse(){
        return new Course(1, "Course 1", "Teacher 1");
    }

    public static List<CourseDTO> getCourseListDTO(){
        List<CourseDTO> courseDTOS = new ArrayList<>();
        courseDTOS.add(getCourseDTO());
        return courseDTOS;
    }

    public static List<Course> getCourseList(){
        List<Course> course = new ArrayList<>();
        course.add(getCourse());
        return course;
    }
}
