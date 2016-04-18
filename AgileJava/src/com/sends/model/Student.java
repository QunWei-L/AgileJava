package com.sends.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.sends.exception.StudentNameLengthException;
import com.sends.support.GradingStrategy;
import com.sends.supportimpl.RegularGradingStrategy;

/**
 * 
 * the class of student
 * 
 * @author qunwei
 *
 */
public class Student {

	public static final String IN_STATE = "ASIA";
	public static final Logger logger=Logger.getLogger(Student.class.getName());

	public enum Grade {
		A(4), B(3), C(2), D(1), E(0.5), F(0);

		private double points = 0;

		Grade(double points) {
			this.points = points;
		}

		public double getPoints() {
			return this.points;
		}

	};

	private static final int FULL_TIME_CREDITS = 12;
	public static final double GRADE_TOLERANCE = 0.05;
	private String name;
	private String state = "";
	private int credits;
	private List<Grade> grades;
	private GradingStrategy gradeStrategy = new RegularGradingStrategy();
	private String firstName="";
	private String middleName="";
	private String lastName;
	

	/**
	 * initialize the sudent
	 * 
	 * @param name
	 *            student's name
	 */
	public Student(String name) {
		// TODO Auto-generated constructor stub
		Student.logger.fine("Begin constractor:"+name+" in "+System.currentTimeMillis());
		
		this.name = name;
		formatName(name);
		
		this.credits = 0;

		this.grades = new ArrayList<Student.Grade>();
		
		Student.logger.fine("End constractor:"+name+" in "+System.currentTimeMillis());
	}

	private void formatName(String name){
		
		List<String> names=new ArrayList<String>();
		for(String part:name.split(" ")){
			names.add(part);
		}
		
		final int maxPartsOfName=3;
		
		if(names.size()>maxPartsOfName){
			String message="The Full name:"+name+" length go beyond the limit :"+maxPartsOfName;
			Student.logger.info(message);
			throw new StudentNameLengthException(message);
		}
		
		setThreePartName(names);
		
	}

	private void setThreePartName(List<String> names) {
		// TODO Auto-generated method stub
		
		lastName=getNamesLast(names);
		
		String temp=getNamesLast(names);
		
		if(names.isEmpty()){
			firstName=temp;
		}else{
			middleName=temp;
			firstName=getNamesLast(names);
		}
		
		
	}

	private String getNamesLast(List<String> names) {
		// TODO Auto-generated method stub
		
		if(names.isEmpty()){
			return "";
		}
		
		return names.remove(names.size()-1);
	}


	/**
	 * 
	 * Get the name of this student
	 * 
	 * @return name
	 */
	public String getName() {

		return this.name;

	}

	public void setState(String state) {
		// TODO Auto-generated method stub
		this.state = state;
	}

	public boolean isInState() {
		// TODO Auto-generated method stub
		return this.state.toUpperCase().equals(Student.IN_STATE);
	}

	public int getCredits() {
		// TODO Auto-generated method stub
		return this.credits;
	}

	public boolean isFullTime() {
		// TODO Auto-generated method stub
		return this.credits >= Student.FULL_TIME_CREDITS;
	}

	public void addCredits(int credit) {
		// TODO Auto-generated method stub
		this.credits += credit;
	}

	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
		this.grades.add(grade);

	}

	public double getGpa() {
		// TODO Auto-generated method stub

		if (grades.size() == 0) {
			return 0;
		}

		double allGrade = 0;

		for (Grade grade : grades) {

			allGrade += getGradeFromSupport(grade);

		}

		return allGrade / grades.size();
	}

	private double getGradeFromSupport(Grade grade) {
		// TODO Auto-generated method stub
		return this.gradeStrategy.getGradePointFor(grade);
	}

	public void setGradeStrategy(GradingStrategy strategy) {
		this.gradeStrategy = strategy;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

}
