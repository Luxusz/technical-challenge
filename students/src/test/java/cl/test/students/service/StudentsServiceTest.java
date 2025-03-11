package cl.test.students.service;

import cl.test.students.client.CoursesClient;
import cl.test.students.dto.CourseDTO;
import cl.test.students.dto.StudentDTO;
import cl.test.students.entity.Student;
import cl.test.students.mapper.StudentMapper;
import cl.test.students.repository.StudentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

import static cl.test.students.dummyobjects.dummyobjects.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentsServiceTest {

    @Mock
    private StudentsRepository studentsRepository;
    @Mock
    private StudentMapper studentMapper;
    @Mock
    private CoursesClient coursesClient;
    
    @InjectMocks
    private StudentsService studentsService;

    @Test
    void getStudentsByCourse() {

        CourseDTO courseDTO = getCourseDTO();
        List<Student> students = geStudentList();

        when(coursesClient.getCourseById(1)).thenReturn(Mono.just(courseDTO));
        when(studentsRepository.findByCourseId(1)).thenReturn(students);
        when(studentMapper.toStudentListDTO(students)).thenReturn(getStudentListDTO());

        List<StudentDTO> result = studentsService.getStudentsByCourse(1);

        assertNotNull(result);
        assertEquals(1, result.size());

    }

    @Test
    void createStudent() {
        StudentDTO StudentDTO = getStudentDTO();

        when(studentMapper.toStudentEntity(any())). thenReturn(getStudent());
        when(studentsRepository.save(any())).thenReturn(getStudent());

        StudentDTO result = studentsService.createStudent(getStudentDTO());

        assertNotNull(result);
        assertEquals(StudentDTO.getName(), result.getName());
    }

    @Test
    void getStudents() {
        List<StudentDTO> StudentDTOList = getStudentListDTO();

        when(studentsRepository.findAll()).thenReturn(geStudentList());
        when(studentMapper.toStudentListDTO(any())).thenReturn(getStudentListDTO());

        List<StudentDTO> result = studentsService.getStudents();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void getStudentById() {
        StudentDTO StudentDTO = getStudentDTO();

        when(studentsRepository.findById(any())).thenReturn(Optional.of(getStudent()));
        when(studentMapper.toStudentDTO(any())).thenReturn(getStudentDTO());

        StudentDTO result = studentsService.getStudentById(1);

        assertNotNull(result);
        assertEquals(StudentDTO.getId(), result.getId());
    }
}