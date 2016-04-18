package com.sends.supportimpl;

import com.sends.model.Student.Grade;
import com.sends.support.GradingStrategy;

public class HonerGradingStrategy extends basicGradingStrategy{

	@Override
	public double getGradePointFor(Grade grade) {
		// TODO Auto-generated method stub

		double honerPoint = 1.0;

		double point = basicGradePointFor(grade);

		if (point > 0.0)
			point += honerPoint;

		return point;
	}

}
