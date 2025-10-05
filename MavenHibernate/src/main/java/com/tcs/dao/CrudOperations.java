package com.tcs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tcs.entity.Student;
import com.tcs.util.HibernateUtil;

public class CrudOperations {

	public void insertStudent(Student s) {

		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
	        if (session != null) session.close();
	    }
	}
}
