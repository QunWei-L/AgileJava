/**
 * 
 */
package com.sends.model;

import java.util.EnumMap;
import java.util.Map;

import org.hamcrest.MatcherAssert;

import com.sends.model.Student.Grade;

/**
 * @author qunwei
 *
 */
public class ReportCard {

	public static final String A_MESSAGE = "Excellent";
	public static final String B_MESSAGE = "Good job";
	public static final String C_MESSAGE = "ehmm";
	public static final String D_MESSAGE = "maybe try harder";
	public static final String E_MESSAGE = "you don\'t even try";
	public static final String F_MESSAGE = "Fucker";
	
	private Map<Student.Grade,String> messageMap=null;

	public String getMessage(Grade grade) {
		// TODO Auto-generated method stub
		return getMessageMap().get(grade);
	}

	private Map<Student.Grade, String> getMessageMap() {
		// TODO Auto-generated method stub
		if(messageMap==null){
			loadMessageMap();
		}
		return messageMap;
	}

	private void loadMessageMap() {
		// TODO Auto-generated method stub
		messageMap=new EnumMap<Student.Grade, String> (Student.Grade.class);
		
		messageMap.put(Student.Grade.A, A_MESSAGE);
		messageMap.put(Student.Grade.B, B_MESSAGE);
		messageMap.put(Student.Grade.C, C_MESSAGE);
		messageMap.put(Student.Grade.D, D_MESSAGE);
		messageMap.put(Student.Grade.E, E_MESSAGE);
		messageMap.put(Student.Grade.F, F_MESSAGE);
		
	}

}
