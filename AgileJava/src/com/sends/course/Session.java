package com.sends.course;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.sends.model.Student;

public class Session implements Comparable<Session>{
	
	private Course course;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();

	private int credit=0;

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
	protected Session(Course course, Date startDate) {
		this.course=course;
		this.startDate = startDate;
	}
	
	public static Session create(Course course, Date startDate) {
		// TODO Auto-generated method stub
		return new Session(course, startDate);
	}
	
	/**
	 * get course's name
	 * 
	 * @return courseName
	 */
	public String getName() {
		return this.course.getCourseName();
	}

	/**
	 * get course's id
	 * 
	 * @return courseId
	 */
	public String getId() {
		return this.course.getCourseId();
	}

	/**
	 * enroll a new student
	 * 
	 * @param student
	 *            Being enrolled student
	 */
	public void enrollStudent(Student student) {
		students.add(student);
		student.addCredits(this.credit);
	}

	/**
	 * 
	 * Get the number of students
	 * 
	 * @return number
	 */
	public int getNumberOfStudents() {
		// TODO Auto-generated method stub
		return students.size();
	}

	/**
	 * 
	 * Get a student from the course by index(enroll order)
	 * 
	 * @param index
	 *            enroll order index
	 * @return student the student of the index
	 */
	public Student getStudentByIndex(int index) {
		// TODO Auto-generated method stub
		return students.get(index);
	}

	/**
	 * 
	 * Get the end date of this course
	 * 
	 * @return endDate
	 */
	public Date getEndDate() {
		// TODO Auto-generated method stub
		GregorianCalendar calendar = new GregorianCalendar();

		calendar.setTime(getStartDate());

		final int courseWeeks = getCourseLength();
		final int daysInWeek = 7;
		final int daysFromFridayToSunday = 3;

		int numberOfDays = courseWeeks * daysInWeek - daysFromFridayToSunday;

		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);

		return calendar.getTime();
	}

	protected int getCourseLength() {
		// TODO Auto-generated method stub
		return 18;
	}

	/**
	 * 
	 * Get the start date of this course
	 * 
	 * @return startDate
	 */
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return startDate;
	}

	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return students;
	}

	public void setCredit(int credit) {
		if (credit>=0) {
			// TODO Auto-generated method stub
			this.credit = credit;
			
		}else{
			
			//Do some thing
			
		}
	}

	@Override
	public int compareTo(Session o) {
		// TODO Auto-generated method stub
		int result=this.getName().compareTo(o.getName());
		
		if (result==0) {
			result= this.getId().compareTo(o.getId());
		}
		
		return result;
	}


}
