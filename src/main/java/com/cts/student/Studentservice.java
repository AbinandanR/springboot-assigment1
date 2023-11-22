package com.cts.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cts.student.Studentmodel;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class Studentservice implements InitializingBean, DisposableBean {
	private static final Logger logger = LoggerFactory.getLogger(Studentservice.class);
    private List<Studentmodel> studentList;
 
    public Studentservice() {
        this.studentList = new ArrayList<>();
    }
 
    public void addStudent(Studentmodel student) {
        studentList.add(student);
    }
 
    public List<Studentmodel> getAllStudents() {
        return studentList;
    }
 
    public Studentmodel getStudentById(int Id) {
        // Implement logic to fetch a student by ID
    	for (Studentmodel student : studentList) {
    		if (student.getId() == Id) {
    			return student;
    		}
    	}
        return null;
    }
 
    public void updateStudentScore(int Id, int newScore) {
        // Implement logic to update a student's score
    	for(Studentmodel student : studentList) {
    		if(student.getId() == Id) {
    			student.setScore(newScore);
    			logScoreMessage(newScore);
    			break;
    		}
    	}
    }
 
    public void deleteStudent(int Id) {
        // Implement logic to delete a student
    	Iterator<Studentmodel> iterator = studentList.iterator();
    	while (iterator.hasNext()) {
    		Studentmodel student = iterator.next();
    		if (student.getId() == Id) {
    			iterator.remove();
    			break;
    		}
    	}
     	
    }
 
    private void logScoreMessage(int newscore) {
        if (newscore < 50) {
            logger.info("Student Score is Below Average");
        } else if (newscore >= 50 && newscore <= 75) {
            logger.info("Student Score is Average");
        } else {
            logger.info("Student Score is Above Average");
        }
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("StudentService has been initiated.");
    }
 
    @Override
    public void destroy() throws Exception {
        logger.info("StudentService is being destroyed.");
    }
}