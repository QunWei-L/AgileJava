/**
 * 
 */
package com.sends.supportimpl;

import com.sends.model.Student.Grade;
import com.sends.support.GradingStrategy;

/**
 * @author qunwei
 *
 */
public class RegularGradingStrategy extends basicGradingStrategy{
	@Override
	public double getGradePointFor(Grade grade) {

		return basicGradePointFor(grade);
	}

}
