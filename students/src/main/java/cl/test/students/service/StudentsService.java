package cl.test.students.service;

import cl.test.students.client.CoursesClient;
import cl.test.students.dto.CourseDTO;
import cl.test.students.dto.StudentDTO;
import cl.test.students.entity.Student;
import cl.test.students.mapper.StudentMapper;
import cl.test.students.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;
    private final StudentMapper studentMapper;
    private final CoursesClient coursesClient;

    public StudentsService(StudentsRepository studentsRepository, StudentMapper studentMapper, CoursesClient coursesClient) {
        this.studentsRepository = studentsRepository;
        this.studentMapper = studentMapper;
        this.coursesClient = coursesClient;
    }

    public List<StudentDTO> getStudentsByCourse(int courseId) {
        List<Student> studentList;
        Mono<CourseDTO> courseDTO = coursesClient.getCourseById(courseId)
                .map(course -> course);
        studentList = studentsRepository.findByCourseId(courseId);
        return studentMapper.toStudentListDTO(studentList);

    }

    public StudentDTO createStudent(StudentDTO student) {
        studentsRepository.save(studentMapper.toStudentEntity(student));
        return student;
    }

    public List<StudentDTO> getStudents() {
        return studentMapper.toStudentListDTO(studentsRepository.findAll());
    }

    public StudentDTO getStudentById(int id) {
        return studentMapper.toStudentDTO(studentsRepository.findById(id).get());
    }
}
