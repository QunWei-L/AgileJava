package com.sends.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.sends.course.Course;
import com.sends.course.CourseSession;
import com.sends.model.Reporter;
import com.sends.model.Student;
import com.sends.util.DateUtil;

public class ReporterTest {

	@Test
	public void testReporter() throws IOException {
		
		CourseSession engl=CourseSession.create(new Course("English", "EG150"), DateUtil.createDate(2016, 3, 1));
		
		engl.enrollStudent(new Student("john"));
		engl.enrollStudent(new Student("mary"));
		
		Reporter rp=new Reporter(engl);
		
		String reportString=rp.getReport();
		
		assertEquals(Reporter.REPORTER_HEADER+Reporter.NEW_LINE+"john"+Reporter.NEW_LINE
				+"mary"+Reporter.NEW_LINE+Reporter.REPORTER_FOOTER+"2",reportString);
		
System.out.println(reportString);
		
	}
	
}
