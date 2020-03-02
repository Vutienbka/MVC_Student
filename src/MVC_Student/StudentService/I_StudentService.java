package MVC_Student.StudentService;

import MVC_Student.Model.Student;

import java.util.List;

public interface I_StudentService {
    List<Student> findAll();
    void save(Student customer);
    Student findById(int Id);
    void update(int Id, Student customer);
    void remove(int Id);
}
