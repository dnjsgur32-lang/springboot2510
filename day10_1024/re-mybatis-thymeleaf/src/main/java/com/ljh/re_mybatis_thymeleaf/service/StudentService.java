package com.ljh.re_mybatis_thymeleaf.service;

import com.ljh.re_mybatis_thymeleaf.domain.Student;
import com.ljh.re_mybatis_thymeleaf.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentMapper studentMapper;

    public List<Student> getAllStudents () {
        return studentMapper.findAll();
    }

    public Student getStudent (Long id) {
        return studentMapper.findById(id);
    }


    @Transactional
    public void createStudent (Student student) {
        studentMapper.insert(student);
    }

    @Transactional
    public void updateStudent (Student student) {
        studentMapper.update(student);
    }

    public void deleteStudent (Long id) {
        studentMapper.delete(id);
    }
}
