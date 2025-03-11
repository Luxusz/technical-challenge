package cl.test.courses.service;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.entity.Course;
import cl.test.courses.mapper.CoursesMapper;
import cl.test.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private CoursesMapper coursesMapper;

    public CourseDTO createCourse(CourseDTO courseDTO){
        Course course1 = coursesMapper.toCourseEntity(courseDTO);
        course1 = coursesRepository.saveAndFlush(course1);
        return coursesMapper.toCourseDTO(course1);
    }

    public List<CourseDTO> getCourses(){
        return coursesMapper
                .toCoursesListDTO(
                        coursesRepository
                                .findAll());
    }
}
