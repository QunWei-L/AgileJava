package com.sends.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.sends.course.Course;

public class CourseTest {

	Course courseA,courseB,courseB_1,courseC;
	
	@Before
	public void setUp() throws Exception {
		
		courseA=new Course("Math", "M101");
		courseB=new Course("Math", "M101");
		courseB_1=new Course("Math", "M101");
		courseC=new Course("Art", "A201");
		
	}

	@Test
	public void testCourse() {
		
		assertEquals(courseB, courseA);
		assertFalse(courseA==courseB);
		assertTrue(courseA.equals(courseB));
		
		assertFalse(courseA.equals(courseC));
		
		assertFalse(courseA.equals(1));
		assertFalse(courseA.equals(null));
		
		//reflexivity
		assertEquals(courseA, courseA);
		
		//transitivity
		
		assertEquals(courseA, courseB);
		assertEquals(courseB, courseB_1);
		assertEquals(courseA, courseB_1);
		
		//symmetry
		
		assertEquals(courseA, courseB);
		assertEquals(courseB, courseA);
	}
	
	@Test
	public void testHashCode(){
		
		Map<Course, Boolean> courseMap=new HashMap<Course, Boolean>();
		courseMap.put(courseA, true);
System.out.println("hash code courseA:"+courseA.hashCode());
System.out.println("hash code courseB:"+courseB.hashCode());
System.out.println("hash code courseC:"+courseC.hashCode());
		assertTrue(courseMap.containsKey(courseB));
		
	}
	
	@Test
	public void testHashPerformance(){
		final int courseCount=10000;
		final long timeLimit=200;
		long start=System.currentTimeMillis();
		
		Map<Course, Boolean> courseMap=new HashMap<Course,Boolean>();
		int i=0;
		while(i<courseCount){
			Course temp=new Course("M"+i, "Mid"+i);
			courseMap.put(temp, true);
			i++;
		}
		long stop=System.currentTimeMillis();
		long elapsed=stop-start;
System.out.println("Course TimeMinus:"+elapsed);

		assertTrue("TimeMinus:"+elapsed+" beyond the limit: "+timeLimit, timeLimit>elapsed);
	}

}
