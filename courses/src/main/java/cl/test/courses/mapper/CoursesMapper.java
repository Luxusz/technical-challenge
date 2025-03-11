package cl.test.courses.mapper;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.entity.Course;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CoursesMapper {

    List<Course> toCoursesListEntity(List<CourseDTO> courseDTO);
    List<CourseDTO> toCoursesListDTO(List<Course> course);

    Course toCourseEntity(CourseDTO courseDTO);
    CourseDTO toCourseDTO(Course course);

}
