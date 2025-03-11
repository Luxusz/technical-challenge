package cl.test.students.controller;

import cl.test.students.dto.StudentDTO;
import cl.test.students.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<StudentDTO>> getStudentByCourse(@PathVariable("courseId") int courseId){
        List<StudentDTO> studentDTOList = studentsService.getStudentsByCourse(courseId);
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student){
        StudentDTO studentDTO = studentsService.createStudent(student);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        List<StudentDTO> studentDTOList = studentsService.getStudents();
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") int id){
        StudentDTO studentDTO = studentsService.getStudentById(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }
}