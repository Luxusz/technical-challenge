package cl.test.courses.service;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.entity.Course;
import cl.test.courses.mapper.CoursesMapper;
import cl.test.courses.repository.CoursesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    private final CoursesRepository coursesRepository;
    private final CoursesMapper coursesMapper;

    public CoursesService(CoursesRepository coursesRepository, CoursesMapper coursesMapper) {
        this.coursesRepository = coursesRepository;
        this.coursesMapper = coursesMapper;
    }

    public CourseDTO createCourse(CourseDTO courseDTO){
        Course course1 = coursesMapper.toCourseEntity(courseDTO);
        course1 = coursesRepository.save(course1);
        return coursesMapper.toCourseDTO(course1);
    }

    public List<CourseDTO> getCourses(){
        return coursesMapper
                .toCoursesListDTO(
                        coursesRepository
                                .findAll());
    }

    public CourseDTO getCourseById(int id){
        Course course  = coursesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id"));
        return coursesMapper.toCourseDTO(course);
    }

    public CourseDTO updateCourseById(int id, CourseDTO courseDTO){
        Optional<Course> courseOptional = coursesRepository.findById(id);
        Course courseUpdate = new Course();

       if(courseOptional.isPresent()){
           Course course = courseOptional.get();
           coursesMapper.updateCourse(courseDTO, course);
           courseUpdate = coursesRepository.save(course);
       }
        return coursesMapper.toCourseDTO(courseUpdate);
    }

    public void deleteCourseById(int id){
        if(coursesRepository.existsById(id)){
            coursesRepository.deleteById(id);
        }
    }
}
