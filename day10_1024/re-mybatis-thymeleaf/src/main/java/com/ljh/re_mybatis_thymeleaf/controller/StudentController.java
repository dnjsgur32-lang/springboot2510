package com.ljh.re_mybatis_thymeleaf.controller;

import com.ljh.re_mybatis_thymeleaf.domain.Student;
import com.ljh.re_mybatis_thymeleaf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //    LIST: 전체 목록
    //    http://localhost:8081/students
    @GetMapping
    public String list (Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    //    FORM 수정용 : 단건 정보 출력
    //    http://localhost:8081/students/9/edit
    @GetMapping("/{id}/edit")
    public String updateForm (@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        return "student/form";
    }

    //    FORM_Blank: 입력준비
    //    http://localhost:8081/students/new
    @GetMapping("/new")
    public String createForm (Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    //    FORM: 수정하기 버튼 클릭후
    //    http://localhost:8081/students/13/edit >> http://localhost:8081/students
    @PostMapping("/{id}")
    public String update (@PathVariable long id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    //    LIST : 정보 삭제
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


}
