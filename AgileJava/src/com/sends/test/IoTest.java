package com.sends.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import com.sends.course.Course;
import com.sends.course.CourseSession;
import com.sends.course.Session;
import com.sends.model.Reporter;
import com.sends.model.Student;
import com.sends.util.DateUtil;

public class IoTest {

	Session session;
	Reporter reporter;
	Writer writer;

	@Before
	public void setUp() throws Exception {

		writer = new StringWriter();

		session = CourseSession.create(new Course("ENG", "E101"), DateUtil.createDate(2016, 3, 1));

		session.enrollStudent(new Student("Ellen"));
		session.enrollStudent(new Student("Rose"));
		session.enrollStudent(new Student("Edison"));

		reporter = new Reporter(session);
	}

	@Test
	public void testStringWriter() throws IOException {

		reporter.getReport(writer);

		assertEquals(Reporter.REPORTER_HEADER + Reporter.NEW_LINE + "Ellen" + Reporter.NEW_LINE + "Rose"
				+ Reporter.NEW_LINE + "Edison" + Reporter.NEW_LINE + 
				Reporter.REPORTER_FOOTER + "3", writer.toString());

	}
	
	@Test
	public void testFileRepoter() throws IOException{
		
		final String fileName = "../IOtestBuffer.txt";

		reporter.getReport(fileName);
		
		StringBuilder buffer = new StringBuilder();
		
		String line;
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		
		while((line = reader.readLine()) != null){
			
			buffer.append(String.format(line+"%n"));
		}
		
		reader.close();
		
		assertEquals(Reporter.REPORTER_HEADER + Reporter.NEW_LINE + "Ellen" + Reporter.NEW_LINE + "Rose"
				+ Reporter.NEW_LINE + "Edison" + Reporter.NEW_LINE + 
				Reporter.REPORTER_FOOTER + "3", getString(buffer));
		
	}

	//more adding a %n
	private Object getString(StringBuilder buffer) {
		// TODO Auto-generated method stub
		return buffer.substring(0, buffer.length()-1);
	}

}
