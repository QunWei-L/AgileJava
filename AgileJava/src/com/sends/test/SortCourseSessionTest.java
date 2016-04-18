package com.sends.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sends.course.Course;
import com.sends.course.CourseSession;
import com.sends.util.DateUtil;

public class SortCourseSessionTest {

	CourseSession d1, d2, d3, m1, m2, e1, e2, e3;
	
	private Course createCourse(String courseName,String courseId){
		return new Course(courseName, courseId);
	}

	@Before
	public void setUp() throws Exception {
		d1 = CourseSession.create
				(createCourse("Design", "D101"), DateUtil.createDate(2016, 3, 1));
		d2 = CourseSession.create
				(createCourse("Design", "D201"), DateUtil.createDate(2016, 2, 29));
		d3 = CourseSession.create
				(createCourse("Design", "D001"), DateUtil.createDate(2016, 3, 1));

		m1 = CourseSession.create
				(createCourse("Math", "M101"), DateUtil.createDate(2016, 3, 1));
		m2 = CourseSession.create
				(createCourse("Math", "M102"), DateUtil.createDate(2016, 2, 29));

		e1 = CourseSession.create
				(createCourse("English", "E101"), DateUtil.createDate(2016, 3, 1));
		e2 = CourseSession.create
				(createCourse("English", "E201"), DateUtil.createDate(2016, 2, 29));
		e3 = CourseSession.create
				(createCourse("English", "E001"), DateUtil.createDate(2016, 3, 1));

	}

	@Test
	public void testSort() {
		
		List<CourseSession> sessions=new ArrayList<CourseSession>();
		sessions.add(e1);
		sessions.add(e2);
		sessions.add(e3);
		sessions.add(d1);
		sessions.add(d2);
		sessions.add(d3);
		sessions.add(m1);
		sessions.add(m2);
		
		Collections.sort(sessions);
		
		for(CourseSession session:sessions){
			
System.out.println(session.getName()+" "+session.getId());
			
		}

	}

}
