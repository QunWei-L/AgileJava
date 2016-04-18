package com.sends.test;

import com.sends.model.Student;

public class StudentTest extends junit.framework.TestCase {

	public void testStudent() {

		final String name = new String("Jie");
		
		Student student_1 = new Student(name);
		
		student_1.setState(Student.IN_STATE);
		
		assertTrue(student_1.isInState());

		assertEquals(name, student_1.getName());

	}

}
