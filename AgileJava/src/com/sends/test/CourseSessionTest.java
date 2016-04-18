package com.sends.test;

import java.util.Date;

import com.sends.course.Course;
import com.sends.course.CourseSession;
import com.sends.course.Session;
import com.sends.model.Student;
import com.sends.util.DateUtil;

import junit.framework.TestCase;

public class CourseSessionTest extends TestCase {

	final String CourseName = "engl";
	final String CourseId = "CS601";
	final int englishCredit=3;
	Session engl;
	Date startDate, sevenTeenAfter;

	public void setUp() {

		CourseSession.resetCount();
		startDate = DateUtil.createDate(2016, 2, 28);
		sevenTeenAfter = DateUtil.createDate(2016, 6, 30);
		engl = CourseSession.create(new Course(CourseName,CourseId), startDate);
		engl.setCredit(englishCredit);
		assertEquals(1, CourseSession.getCreateCount());

	}

	public void testCourseSession() {

		assertEquals(CourseName, engl.getName());
		assertEquals(CourseId, engl.getId());
		assertEquals(startDate, engl.getStartDate());
		assertEquals(sevenTeenAfter, engl.getEndDate());

	}

	public void testEnrollStudent() {
		Student rose = new Student("Rose Lolly");
		engl.enrollStudent(rose);
		assertEquals(englishCredit, rose.getCredits());
		assertFalse(rose.isFullTime());
		assertEquals(1, engl.getNumberOfStudents());
		int index = 0;
		assertEquals(rose, engl.getStudentByIndex(index));

	}

}
