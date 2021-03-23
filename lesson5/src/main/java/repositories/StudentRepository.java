package repositories;

import dao.BaseDao;
import model.Student;
import services.DbService;

public class StudentRepository {
    private static StudentRepository studentRepository;

    public static StudentRepository getInstance() {
        if(studentRepository == null) {
            studentRepository = new StudentRepository();
        }
        return studentRepository;
    }

    private BaseDao<Student> studentDao;
    private StudentRepository() {
        this.studentDao = new BaseDao<>(Student.class);
    }

    public Student get(Long id) {
       return studentDao.get(id);
    }

    public boolean saveOrUpdate(Student student) {
        return studentDao.saveOrUpdate(student);
    }

}
