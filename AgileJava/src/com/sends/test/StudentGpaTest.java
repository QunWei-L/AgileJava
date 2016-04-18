package com.sends.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sends.model.Student;
import com.sends.supportimpl.HonerGradingStrategy;

public class StudentGpaTest {

	Student mark,jim;
	
	@Before
	public void setUp() throws Exception {
		
		mark=new Student("mark");
		jim=new Student("jim");
		jim.setGradeStrategy(new HonerGradingStrategy());
	}

	@Test
	public void testGpa() {
		
		mark.addGrade(Student.Grade.A);
		jim.addGrade(Student.Grade.A);
		
		assertEquals(4.0,mark.getGpa(),Student.GRADE_TOLERANCE);
		assertEquals(5.0,jim.getGpa(),Student.GRADE_TOLERANCE);
		
		mark.addGrade(Student.Grade.B);
		jim.addGrade(Student.Grade.B);
		
		assertEquals(3.5,mark.getGpa(),Student.GRADE_TOLERANCE);
		assertEquals(4.5,jim.getGpa(),Student.GRADE_TOLERANCE);
		
	}

}
