package com.sends.course;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.sends.model.Student;

/**
 * 
 * The Course of University each semester
 * 
 * @author qunwei
 *
 */

public class CourseSession extends Session{
	
	private static int count;


	/**
	 * initialize the CourseSession
	 * 
	 * @param courseName
	 *            the course's name
	 * @param courseId
	 *            the course's id
	 * @param startDate
	 *            the course's start date
	 */
	protected CourseSession(Course course, Date startDate) {
		super(course,startDate);
	}
	
	public static CourseSession create(Course course, Date startDate) {
		// TODO Auto-generated method stub
		CourseSession.increseCount();
		return new CourseSession(course, startDate);
	}
	
	public static void resetCount() {
		// TODO Auto-generated method stub
		CourseSession.count=0;
	}
	
	private static void  increseCount(){
		
		CourseSession.count++;
		
	}
	
	public static int getCreateCount() {
		// TODO Auto-generated method stub
		return CourseSession.count;
	}


}
