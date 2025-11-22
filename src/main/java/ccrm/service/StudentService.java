package ccrm.service;

import ccrm.dao.StudentRepository;
import ccrm.model.Student;
import java.util.Collection;

public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void addStudent(String id, String name, String email, String program, int year) {
        Student s = new Student(id, name, email, program, year);
        repo.save(s);
    }

    public Student getStudent(String id) {
        return repo.findById(id);
    }

    public Collection<Student> listStudents() {
        return repo.findAll();
    }
}
