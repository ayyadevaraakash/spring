package com.tcs.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcs.dao.CrudOperations;
import com.tcs.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String path = "/com/tcs/resources/ApplicationContext.xml";
    	ApplicationContext context = new ClassPathXmlApplicationContext(path);
    	
    	CrudOperations obj = context.getBean(CrudOperations.class);
    	
    	Student s = new Student();
    	s.setId(1);
    	s.setFirstName("akash");
    	s.setLastName("ayyadevara");
    	s.setCity("mumbai");
    	s.setMarks(79);
    	obj.insertStudent(s);
    }
}
