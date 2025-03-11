package cl.test.students.mapper;

import cl.test.students.dto.StudentDTO;
import cl.test.students.entity.Student;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentMapper {

    List<Student> toStudentsListEntity(List<StudentDTO> studentDTO);
    List<StudentDTO> toStudentListDTO(List<Student> student);

    Student toStudentEntity(StudentDTO studentDTO);
    StudentDTO toStudentDTO(Student student);
}
