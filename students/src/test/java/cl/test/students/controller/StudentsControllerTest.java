package cl.test.students.controller;

import cl.test.students.dto.StudentDTO;
import cl.test.students.service.StudentsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static cl.test.students.dummyobjects.dummyobjects.getStudentDTO;
import static cl.test.students.dummyobjects.dummyobjects.getStudentListDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentsControllerTest {

    @Mock
    private StudentsService studentsService;

    @InjectMocks
    private StudentsController studentsController;

    @Test
    void getStudentByCourse() {
        List<StudentDTO> studentDTOList = getStudentListDTO();

        when(studentsService.getStudentsByCourse(1)).thenReturn(studentDTOList);

        ResponseEntity<List<StudentDTO>> response = studentsController.getStudentByCourse(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(studentDTOList, response.getBody());

    }

    @Test
    void createStudent() {
        StudentDTO studentDTO = getStudentDTO();

        when(studentsService.createStudent((any()))).thenReturn(studentDTO);

        ResponseEntity<StudentDTO> response = studentsController.createStudent(any());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(studentDTO, response.getBody());
    }

    @Test
    void getStudents() {
        List<StudentDTO> studentDTOList = getStudentListDTO();

        when(studentsService.getStudents()).thenReturn(studentDTOList);

        ResponseEntity<List<StudentDTO>> response = studentsController.getStudents();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(studentDTOList, response.getBody());
    }

    @Test
    void getStudentById() {
        StudentDTO studentDTO = getStudentDTO();

        when(studentsService.getStudentById(1)).thenReturn(studentDTO);

        ResponseEntity<StudentDTO> response = studentsController.getStudentById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(studentDTO, response.getBody());
    }
}