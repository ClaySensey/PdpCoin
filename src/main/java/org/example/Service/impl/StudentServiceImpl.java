package org.example.Service.impl;

import org.example.modul.Student ;
import org.example.modul.Teacher;
import org.example.repostriys.UserRepository;

import java.util.List;

public class StudentServiceImpl extends UserRepository {
    private UserRepository userRepository;

    public StudentServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public StudentServiceImpl() {

    }

    @Override
    public Student create(Student student) {
        return userRepository.create(student);
    }

    @Override
    public Student getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return userRepository.getAll();
    }

    @Override
    public Student update(long id, Student updatedStudent) {
        return userRepository.update(id, updatedStudent);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}

