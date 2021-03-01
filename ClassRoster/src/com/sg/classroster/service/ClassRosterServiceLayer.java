package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;


public interface ClassRosterServiceLayer {

    public void createStudent(Student student) throws ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;

    public List<Student> getAllStudents() throws ClassRosterPersistenceException;

    public Student getStudent(String studentId) throws ClassRosterPersistenceException;

    public Student removeStudent(String studentId) throws ClassRosterPersistenceException;
}
