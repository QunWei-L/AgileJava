/**
 * 
 */
package com.sends.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sends.course.Course;
import com.sends.course.CourseSession;
import com.sends.course.Session;
import com.sends.course.SummerCourseSession;
import com.sends.util.DateUtil;

/**
 * @author qunwei
 *
 */
public class SummerCourseSessionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSummerCourseSession() {
		
		Session session=SummerCourseSession.create(new Course("Math", "M101"), DateUtil.createDate(2016, 2, 12));
		
		assertEquals("Math",session.getName());
		
		assertEquals(DateUtil.createDate(2016, 4, 5), session.getEndDate());
		
System.out.println(session.getEndDate());
		
	}

}
