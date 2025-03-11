package cl.test.courses.controller;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @PostMapping("/")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        CourseDTO courseDTO1 = coursesService.createCourse(courseDTO);
        return new ResponseEntity<>(courseDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getCourses(){
        List<CourseDTO> courses = coursesService.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
