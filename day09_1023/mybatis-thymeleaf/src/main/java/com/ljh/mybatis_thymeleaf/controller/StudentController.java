package com.ljh.mybatis_thymeleaf.controller;

import java.util.List;

import com.ljh.mybatis_thymeleaf.domain.Student;
import com.ljh.mybatis_thymeleaf.service.StudentService;
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
    @GetMapping
    public String list (Model model) {
        //  전체 학생의 리스트 값을 화면에 변수(s)로 전달한다.
        model.addAttribute("students", studentService.getAllstudents());
        return "student/list";
    }

    //    FORM_Blank: 입력준비
    @GetMapping("/new")
    public String createForm (Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    //    FORM: 저장하기 버튼 클릭후
    @PostMapping
    public String create (@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }


    //    FORM 수정용 : 단건 정보 출력
    @GetMapping("/{id}/edit")
    public String updateForm (@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        return "student/form";
    }

    //    FORM: 수정하기 버튼 클릭후
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
