package com.tcs.main;

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
        Student s = new Student();
        s.setName("Ganesh");
        s.setRollNumber(18);
        s.setGender("Male");
        
        CrudOperations obj = new CrudOperations();
        obj.insertStudent(s);
    }
}
