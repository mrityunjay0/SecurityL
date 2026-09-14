package com.security.learningjwt.controller;

import com.security.learningjwt.dto.StudentRequestDto;
import com.security.learningjwt.dto.StudentResponseDto;
import com.security.learningjwt.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create a new student
    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(
            @Valid @RequestBody StudentRequestDto studentRequestDto) {

        StudentResponseDto createdStudent = studentService.createStudent(studentRequestDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // Get all students
    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {

        List<StudentResponseDto> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Get a student by ID
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long studentId) {

        StudentResponseDto student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Update a student
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @Valid @RequestBody StudentRequestDto studentRequestDto, @PathVariable Long studentId) {

        StudentResponseDto updatedStudent = studentService.updateStudent(studentRequestDto, studentId);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // Delete a student
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {

        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
