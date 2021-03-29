package lesson7.services;

import lesson7.dto.StudentDto;
import lesson7.entities.Student;
import lesson7.exceptions.StudentNotFoundException;
import lesson7.mappers.StudentMapper;
import lesson7.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    public List<StudentDto> getStudentsDto() {
        return studentsRepository.findAllDtoedBy();
    }

    public Student findByID(Long id) {
        return studentsRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Can't found student with id = " + id));
    }

    public StudentDto findByIDDto(Long id) {
        return studentsRepository.findDtoById(id).orElseThrow(() -> new StudentNotFoundException("Can't found student with id = " + id));
    }

    public Student saveOrUpdate(Student student) {
        return studentsRepository.save(student);
    }

    public Student saveOrUpdate(StudentDto studentDto) {
        Student student = StudentMapper.MAPPER.fromStudentDto(studentDto);
        return studentsRepository.save(student);
    }

    public void delete(Long id) {
        studentsRepository.deleteById(id);
    }


}
