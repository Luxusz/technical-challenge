package cl.test.courses.repository;

import cl.test.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {

}
