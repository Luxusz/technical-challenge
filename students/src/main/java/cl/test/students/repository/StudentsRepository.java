package cl.test.students.repository;

import cl.test.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseId(Long courseId);
}