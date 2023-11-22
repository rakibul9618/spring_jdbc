package org.spring.jdbc;

import org.spring.jdbc.config.JdbcConfig;
import org.spring.jdbc.dao.StudentDao;
import org.spring.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao sutdentDao = context.getBean("studentDaoImpl", StudentDao.class);
//       Insert value
//        Student student = new Student(103, "Tonmoy", "Barishal");
//        int result = sutdentDao.insert(student);
//        System.out.println("Number of insertion " + result);

//      Update value
//        Student student = new Student(102, "Rashed", "Chittagong");
//        int result = sutdentDao.update(student);
//        System.out.println("Number of update " + result);

//      Get a student object value
//        Student result = sutdentDao.getStudent(102);
//        System.out.println("Number of update " + result);

//      Get all student object value
        List<Student> studentList = sutdentDao.getAllStudent();

        for (Student student: studentList) {
            System.out.println("Number of update " + student);

        }
    }
}
