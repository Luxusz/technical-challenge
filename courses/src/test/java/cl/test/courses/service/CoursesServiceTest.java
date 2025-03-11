package cl.test.courses.service;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.entity.Course;
import cl.test.courses.mapper.CoursesMapper;
import cl.test.courses.repository.CoursesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static cl.test.courses.dummyobjects.DummyObjects.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursesServiceTest {

    @Mock
    private CoursesRepository coursesRepository;

    @Mock
    private CoursesMapper coursesMapper;

    @InjectMocks
    private CoursesService coursesService;


    @Test
    void createCourse() {
        CourseDTO courseDTO = getCourseDTO();

        when(coursesMapper.toCourseEntity(any())). thenReturn(getCourse());
        when(coursesRepository.save(any())).thenReturn(getCourse());
        when(coursesMapper.toCourseDTO(any())).thenReturn(getCourseDTO());

        CourseDTO result = coursesService.createCourse(getCourseDTO());

        assertNotNull(result);
        assertEquals(courseDTO.getNameCourse(), result.getNameCourse());
    }

    @Test
    void getCourses() {
        List<CourseDTO> courseDTOList = getCourseListDTO();

        when(coursesRepository.findAll()).thenReturn(getCourseList());
        when(coursesMapper.toCoursesListDTO(any())).thenReturn(getCourseListDTO());

        List<CourseDTO> result = coursesService.getCourses();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void getCourseById() {
        CourseDTO courseDTO = getCourseDTO();

        when(coursesRepository.findById(any())).thenReturn(Optional.of(getCourse()));
        when(coursesMapper.toCourseDTO(any())).thenReturn(getCourseDTO());

        CourseDTO result = coursesService.getCourseById(1);

        assertNotNull(result);
        assertEquals(courseDTO.getId(), result.getId());

    }

    @Test
    void updateCourseById() {
        CourseDTO courseDTO = getCourseDTO();

        when(coursesRepository.findById(any())).thenReturn(Optional.of(getCourse()));
        doNothing().when(coursesMapper).updateCourse(any(), any());
        when(coursesMapper.toCourseDTO(any())).thenReturn(getCourseDTO());

        CourseDTO result = coursesService.updateCourseById(1, getCourseDTO());

        verify(coursesMapper).updateCourse(any(CourseDTO.class), any(Course.class));
        assertNotNull(result);

    }

    @Test
    void deleteCourseById() {
        when(coursesRepository.existsById(1)).thenReturn(true);

        coursesService.deleteCourseById(1);

        verify(coursesRepository, times(1)).deleteById(1);
    }
}