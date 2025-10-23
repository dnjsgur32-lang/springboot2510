package com.ljh.mybatis_thymeleaf.mapper;

import com.ljh.mybatis_thymeleaf.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();

    Student findById (Long id);

    void insert (Student student);

    void update (Student student);

    void delete (Long id);
}
