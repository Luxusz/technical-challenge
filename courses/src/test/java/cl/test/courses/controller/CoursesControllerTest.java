package cl.test.courses.controller;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.service.CoursesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static cl.test.courses.dummyobjects.DummyObjects.getCourseDTO;
import static cl.test.courses.dummyobjects.DummyObjects.getCourseListDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoursesControllerTest {

    @Mock
    private CoursesService coursesService;

    @InjectMocks
    private CoursesController coursesController;

    @Test
    void createCourse() {
        CourseDTO courseDTO = getCourseDTO();

        when(coursesService.createCourse((any()))).thenReturn(courseDTO);

        ResponseEntity<CourseDTO> response = coursesController.createCourse(any());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(courseDTO, response.getBody());
    }

    @Test
    void getCourses() {
        List<CourseDTO> courseDTOList = getCourseListDTO();

        when(coursesService.getCourses()).thenReturn(courseDTOList);

        ResponseEntity<List<CourseDTO>> response = coursesController.getCourses();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(courseDTOList, response.getBody());
    }

    @Test
    void getCourseById() {
        CourseDTO courseDTO = getCourseDTO();

        when(coursesService.getCourseById(1)).thenReturn(courseDTO);

        ResponseEntity<CourseDTO> response = coursesController.getCourseById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(courseDTO, response.getBody());
    }

    @Test
    void updateCourseById() {
        CourseDTO courseDTO = getCourseDTO();

        when(coursesService.updateCourseById(1, courseDTO)).thenReturn(courseDTO);

        ResponseEntity<CourseDTO> response = coursesController.updateCourseById(1, courseDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(courseDTO, response.getBody());
    }

    @Test
    void deleteCourseById() {

        doNothing().when(coursesService).deleteCourseById(1);

        ResponseEntity<String> response = coursesController.deleteCourseById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Successful", response.getBody());
        verify(coursesService,times(1)).deleteCourseById(1);

    }
}