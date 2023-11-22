package org.spring.jdbc.dao;

import org.spring.jdbc.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        // Insert query
        String query = "insert into student() values(?,?,?)";

        return this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
    }

    @Override
    public int update(Student student) {
        // Insert query
        String query = "update student set name=?, city=? where id=?";

        return this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public int delete(int studentId) {
        // Insert query
        String query = "delete from student where id=?";
        return this.jdbcTemplate.update(query, studentId);
    }

    @Override
    public Student getStudent(int studentId) {
        // Insert query
        String query = "select * from student where id=?";

        RowMapperImpl rowMapper = new RowMapperImpl();
        return this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        // Insert query
        String query = "select * from student";
        return this.jdbcTemplate.query(query, new RowMapperImpl());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
