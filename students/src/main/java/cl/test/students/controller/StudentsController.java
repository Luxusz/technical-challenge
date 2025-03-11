package cl.test.students.controller;

import cl.test.students.dto.StudentDTO;
import cl.test.students.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<StudentDTO>> getStudentByCourse(@PathVariable(("courseId")) Long courseId){
        List<StudentDTO> studentDTOList = studentsService.getStudentsByCourse(courseId);
        return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
    }

    @PostMapping("/")
    public StudentDTO createStudent(@RequestBody StudentDTO student){
        return studentsService.createStudent(student);
    }
}
