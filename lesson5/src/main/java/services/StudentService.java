package services;

import model.Student;
import repositories.StudentRepository;

public class StudentService {
    private static StudentService studentService;

    public static StudentService getInstance() {
        if(studentService == null) {
            studentService = new StudentService();
        }
        return studentService;
    }
    private StudentRepository studentRepository;

    private StudentService() {
        this.studentRepository = StudentRepository.getInstance();
    }

    public Student get(Long id) {
        return studentRepository.get(id);
    }

    public boolean saveOrUpdate(Student student) {
        return studentRepository.saveOrUpdate(student);
    }
}
