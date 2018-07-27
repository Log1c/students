package base.students.service;

import base.students.entities.Student;
import base.students.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    public void insert(Student student) {
        studentsRepository.save(student);
    }
}
