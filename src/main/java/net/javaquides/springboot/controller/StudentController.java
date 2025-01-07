package net.javaquides.springboot.controller;

import net.javaquides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Ranga", "Karaganda");
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ranga", "Karaganda"));
        students.add(new Student(2, "John", "Walter"));
        students.add(new Student(3, "Tom", "Cruise"));
        students.add(new Student(4, "Tony", "Stark"));
        return students;
    }

    // Spring BOOT REST API with Path Variable
    // {} - URI template variable
    // http://localhost:8080/student/1

    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

}
