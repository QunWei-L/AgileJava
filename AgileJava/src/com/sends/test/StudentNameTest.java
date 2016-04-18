package com.sends.test;

import static org.junit.Assert.*;

import java.util.logging.Handler;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.sends.exception.StudentHandler;
import com.sends.exception.StudentNameLengthException;
import com.sends.model.Student;

public class StudentNameTest {

	private Student jarky, mark_jordon,marks_engus_bonus,j_k_l_m;

	@Before
	public void setUp() throws Exception {

		jarky = new Student("jarky");
		mark_jordon = new Student("mark jordon");
		marks_engus_bonus=new Student("Marks Engus Bonus");
		try {
			j_k_l_m=new Student("John kill legue max");
			fail("Bad Student name");
		} catch (StudentNameLengthException expected) {
			// TODO Auto-generated catch block
			Logger logger=Logger.getLogger(Student.class.getName());
			
			assertEquals(logger, Student.logger);
//Not format for delete
System.out.println(logger==Student.logger);


//			Handler handler=new StudentHandler();
//			Student.logger.addHandler(handler);
//System.out.println(((StudentHandler)handler).getMessage());
//			assertEquals(expected.getMessage(), ((StudentHandler)handler).getMessage());
			
			String trace="The Full name:John kill legue max length go beyond the limit :3";
			assertEquals(trace, expected.getMessage());
		}
	}

	@Test
	public void testBreakName() {

		assertEquals("", jarky.getFirstName());
		assertEquals("", jarky.getMiddleName());
		assertEquals("jarky", jarky.getLastName());
		
		assertEquals("mark", mark_jordon.getFirstName());
		assertEquals("", mark_jordon.getMiddleName());
		assertEquals("jordon", mark_jordon.getLastName());
		
		assertEquals("Marks", marks_engus_bonus.getFirstName());
		assertEquals("Engus", marks_engus_bonus.getMiddleName());
		assertEquals("Bonus", marks_engus_bonus.getLastName());
		
	}

}
