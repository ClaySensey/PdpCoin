package org.example.Service;

import org.example.modul.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);

    Student get(long chatId);

    List<Student> getAll();

    Student update(long chatId, Student student);

    Student delete(long chatId);
}
