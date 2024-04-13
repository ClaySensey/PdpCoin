package org.example.Service.impl;

import org.example.modul.Subject;
import org.example.repositories.SubjectRepository;
import org.example.Service.SubjectService ;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAllSubject();
    }

    @Override
    public Subject getSubjectById(long id) {
        return subjectRepository.getSubjectById(id);
    }

    @Override
    public boolean createSubject(Subject subject) {
        return subjectRepository.createSubject(subject);
    }

    @Override
    public boolean updateSubjectById(Long id, Subject subject) {
        return subjectRepository.updateSubjectById(id, subject);
    }
}