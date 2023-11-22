package com.cts.student;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.cts.student.Studentservice;

@SpringBootApplication
public class StudentsDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsDetailsApplication.class, args);
			
		Studentservice studentService = new Studentservice();
		 
        // Add a few students
        studentService.addStudent(new Studentmodel(23, "abc", 80 /* provide id, name, score */));
        studentService.addStudent(new Studentmodel(24, "xyz", 70 /* provide id, name, score */));
        studentService.addStudent(new Studentmodel(25, "pqr", 45/* provide id, name, score */));
        
        // Fetch and display the students
        List<Studentmodel> students = studentService.getAllStudents();
        System.out.println("All Students: " + students);
 
        // Update scores and observe the scoring system logs
        studentService.updateStudentScore(1, 40); // Below Average
        studentService.updateStudentScore(2, 60); // Average
        studentService.updateStudentScore(3, 80); // Above Average
 
        // Remove a student
        studentService.deleteStudent(2);
        students = studentService.getAllStudents();
        System.out.println("Updated Students: " + students);
	}

}
