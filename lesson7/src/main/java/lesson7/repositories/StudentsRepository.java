package lesson7.repositories;

import lesson7.entities.Student;
import lesson7.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    List<StudentDto> findAllDtoedBy();
    Optional<StudentDto> findDtoById(Long id);
}

