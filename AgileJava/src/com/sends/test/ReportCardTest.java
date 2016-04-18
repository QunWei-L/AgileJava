package com.sends.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sends.model.ReportCard;
import com.sends.model.Student;

public class ReportCardTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReportCard() {

		
		long start = System.currentTimeMillis();
		
		ReportCard card=new ReportCard();
		
		assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
		
		assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.E_MESSAGE, card.getMessage(Student.Grade.E));
		assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
		
		long stop=System.currentTimeMillis();
		long elapsed=stop-start;
		System.out.println("ReportCard TimeMinus:"+elapsed);
	}

}
