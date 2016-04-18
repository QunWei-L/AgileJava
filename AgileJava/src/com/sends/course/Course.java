package com.sends.course;

import java.util.logging.Logger;

import com.sends.exception.CastException;

public class Course{
	
	public static final Logger logger=Logger.getLogger(Course.class.getName());

	private String courseName;

	private String courseId;

	public Course(String courseName,String courseId){
		
		this.courseName=courseName;
		this.courseId=courseId;
		
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseId() {
		return courseId;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int hashMultiplier=41;
		int result = 7;
		result=result * hashMultiplier + this.getCourseId().hashCode();
		result=result * hashMultiplier + this.getCourseName().hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		try {
			
			Course that = (Course) obj;
			if (this.courseName.equals(that.getCourseName()) && this.courseId.equals(that.getCourseId())) {

				return true;

			} else {

				return false;
			} 
		} catch (Exception castException) {
			
			if(obj==null){
				Course.logger.info("Expected:the object is null");
			}else if(this.getClass()!=obj.getClass()){
				
				this.logger.info("Expected:the class:"+obj.getClass()+" can not cast to "+ this.getClass());
				
			}
			
			return super.equals(obj);
			
		}
		
	}
}
