package org.spring.jdbc;

import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao sutdentDao = context.getBean("studentDaoImpl", StudentDao.class);

        Student student = new Student(103, "Tonmoy", "Barishal");

        //Fire query
        int result = sutdentDao.insert(student);
        System.out.println("Number of insertion " + result);
    }
}