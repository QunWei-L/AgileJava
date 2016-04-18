package com.sends.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sends.model.Student;
import com.sends.supportimpl.RegularGradingStrategy;

public class RegularGradingStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegularGradingStrategy() {
		
		RegularGradingStrategy regular=new RegularGradingStrategy();
		
		assertEquals(4.0,regular.getGradePointFor(Student.Grade.A),Student.GRADE_TOLERANCE);
		assertEquals(3.0,regular.getGradePointFor(Student.Grade.B),Student.GRADE_TOLERANCE);
		assertEquals(2.0,regular.getGradePointFor(Student.Grade.C),Student.GRADE_TOLERANCE);
		assertEquals(1.0,regular.getGradePointFor(Student.Grade.D),Student.GRADE_TOLERANCE);
		assertEquals(0.5,regular.getGradePointFor(Student.Grade.E),Student.GRADE_TOLERANCE);
		assertEquals(0.0,regular.getGradePointFor(Student.Grade.F),Student.GRADE_TOLERANCE);
		
	}

}
