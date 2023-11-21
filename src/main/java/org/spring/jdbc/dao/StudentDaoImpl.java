package org.spring.jdbc.dao;

import org.spring.jdbc.entites.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {

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

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
