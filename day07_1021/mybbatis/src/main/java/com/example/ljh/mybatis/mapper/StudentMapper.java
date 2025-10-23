package com.example.ljh.mybatis.mapper;

import com.example.ljh.mybatis.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();

    //    @Select("SELECT * FROM student(NAME, email, age) \r\n" + " VALUES (#{name}, #{email}, #{age})" )
//      @Insert(INSERT INTO student(NAME, email, age) \r\n"
//    + " VALUES (#{name}, #{email}, #{age})

//    @Options(useGeneratedKeys = true, keyProperty = "id")


//    @Update("UPDATE student \r\n"
//    + "SET NAME = #{name}, email = #{email}, age = #{age}\r\n"
//    +"WHERE id = #{id}")

//    @Delete("DELETE FROM student WHERE id = #{id}")
//    void delete(Long id);


    Student findById(Long id);

    void insert(Student student);

    void update(Student student);

    void delete(Long id);
}
