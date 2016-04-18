package com.sends.test;

import static org.junit.Assert.*;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Before;
import org.junit.Test;

import com.sends.model.Student;
import com.sends.supportimpl.HonerGradingStrategy;

public class HonerGradingStrategyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHonerGradingStrategy() {
		
		assertEquals(5.0, new HonerGradingStrategy().getGradePointFor(Student.Grade.A),Student.GRADE_TOLERANCE);
		assertEquals(4.0, new HonerGradingStrategy().getGradePointFor(Student.Grade.B),Student.GRADE_TOLERANCE);
		assertEquals(3.0, new HonerGradingStrategy().getGradePointFor(Student.Grade.C),Student.GRADE_TOLERANCE);
		assertEquals(2.0, new HonerGradingStrategy().getGradePointFor(Student.Grade.D),Student.GRADE_TOLERANCE);
		assertEquals(1.5, new HonerGradingStrategy().getGradePointFor(Student.Grade.E),Student.GRADE_TOLERANCE);
		assertEquals(0.0, new HonerGradingStrategy().getGradePointFor(Student.Grade.F),Student.GRADE_TOLERANCE);
		
	}

}
