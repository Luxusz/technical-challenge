package cl.test.students.service;

import cl.test.students.dto.StudentDTO;
import cl.test.students.mapper.StudentMapper;
import cl.test.students.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDTO> getStudentsByCourse(Long courseId) {
        return studentMapper.toStudentListDTO(studentsRepository.findByCourseId(courseId));
    }

    public StudentDTO createStudent(StudentDTO student) {
        studentsRepository.save(studentMapper.toStudentEntity(student));
        return student;
    }
}
