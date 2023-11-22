package org.spring.jdbc.config;

import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"org.spring.jdbc.dao"})
public class JdbcConfig {

    @Bean("ds")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean("JdbcTemplate")
    public JdbcTemplate getTemplate () {

        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
    }

//    @Bean("studentDaoImpl")
//    public StudentDao getstudentDao (){
//        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.setJdbcTemplate(getTemplate());
//        return studentDao;
//    }

}
