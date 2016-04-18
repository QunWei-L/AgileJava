package com.sends.support;

import com.sends.model.Student;

public interface GradingStrategy {

	public double getGradePointFor(Student.Grade grade);
	
}
