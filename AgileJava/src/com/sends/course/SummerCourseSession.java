package com.sends.course;

import java.util.Date;

public class SummerCourseSession extends Session {
	
	
	public static SummerCourseSession create(Course course, Date startDate) {
		// TODO Auto-generated method stub
		return new SummerCourseSession(course, startDate);
	}
	
	private SummerCourseSession(Course course, Date startDate){
		
		super(course, startDate);
		
	}
	@Override
	protected int getCourseLength() {
		// TODO Auto-generated method stub
		return 8;
	}
	

}
