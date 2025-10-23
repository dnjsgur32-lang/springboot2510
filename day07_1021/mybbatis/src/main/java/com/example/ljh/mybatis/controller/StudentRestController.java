package com.example.ljh.mybatis.controller;

import com.example.ljh.mybatis.domain.Student;
import com.example.ljh.mybatis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

//    방법 1 : Dependency injection
//    @Autowired (getter, setter)
//    private StudentService studentService;

//    방법 2 : Dependency ingection
//    private final StudentService student service;
//    public StudentRestController (StudentService studentService){
//    this.studentService = studentService;
//    }

//    방법 3 : Dependency ingection - 롬복(lombok)
//    @RequiredArgsConstructor
//    public class StudentRestController{
//    private final StudentService studentService;
//    }

    private final StudentService studentService;

    //  전체 조회 : GET http://localhost:8080/api/students
    @GetMapping
    public List<Student> list() {
        return studentService.getAllStudents();
    }

    //  단건 조회 : GET http://localhost:8080/api/students/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> detail(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    //  등록 : POST http://localhost:8080/api/students
    //  {
    //   "name" : "테스트2",
    //   "email" : "test@test.com",
    //   "age" : 20
    //}
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

    //  수정 : put
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return ResponseEntity.ok(student);
    }


//  삭제 : delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }



}
