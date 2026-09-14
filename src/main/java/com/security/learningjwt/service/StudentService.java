package com.security.learningjwt.service;

import com.security.learningjwt.dto.StudentRequestDto;
import com.security.learningjwt.dto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    // create student
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto);

    // get all students
    public List<StudentResponseDto> getAllStudents();

    // get student by id
    public StudentResponseDto getStudentById(Long studentId);

    // update student
    public StudentResponseDto updateStudent(StudentRequestDto studentRequestDto, Long studentId);

    // delete student
    public void deleteStudent(Long studentId);

}
