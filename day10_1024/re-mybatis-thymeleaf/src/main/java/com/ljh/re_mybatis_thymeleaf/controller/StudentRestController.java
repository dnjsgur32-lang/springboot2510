package com.ljh.re_mybatis_thymeleaf.controller;

import com.ljh.re_mybatis_thymeleaf.domain.Student;
import com.ljh.re_mybatis_thymeleaf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {
    //    데이터 타입 : String 등등..
    private final StudentService studentService;

    //    전체 조회 : (http://localhost:8081/api/students)
    @GetMapping
    public List<Student> list () {
        return studentService.getAllStudents();
    }

    //    단건 조회 : (http://localhost:8081/api/students/1)
    @GetMapping("/{id}")
    public ResponseEntity<Student> detail (@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    //    등록: 학생 추가 POST (http://localhost:8081/api/students)
    @PostMapping
    public ResponseEntity<Student> create (@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

    //    수정 : 정보 수정 PUT (http://localhost:8081/api/students/5)
    @PutMapping("/{id}")
    public ResponseEntity<Student> update (@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        studentService.updateStudent(student);

        return ResponseEntity.ok(student);
    }

    //    삭제 : 정보 삭제 DELETE (http://localhost:8081/api/students/5)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
