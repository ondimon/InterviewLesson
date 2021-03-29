package lesson7.mappers;

import lesson7.dto.StudentDto;
import lesson7.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);
    Student fromStudentDto(StudentDto studentDto);
    StudentDto fromStudent(Student student);

}
