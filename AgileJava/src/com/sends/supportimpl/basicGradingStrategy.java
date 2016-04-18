package com.sends.supportimpl;

import com.sends.model.Student.Grade;
import com.sends.support.GradingStrategy;

public abstract class basicGradingStrategy implements GradingStrategy {

	@Override
	abstract public double getGradePointFor(Grade grade);

	protected double basicGradePointFor(Grade grade) {
		return grade.getPoints();
	}

}
