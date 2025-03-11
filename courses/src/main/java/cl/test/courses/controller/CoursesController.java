package cl.test.courses.controller;

import cl.test.courses.dto.CourseDTO;
import cl.test.courses.service.CoursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

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

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") int id){
        CourseDTO course = coursesService.getCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourseById(@PathVariable("id") int id, @RequestBody CourseDTO courseDTO){
        CourseDTO courseDTO1 = coursesService.updateCourseById(id, courseDTO);
        return new ResponseEntity<>(courseDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("id") int id){
        coursesService.deleteCourseById(id);
        return ResponseEntity.ok("Successful");
    }
}
