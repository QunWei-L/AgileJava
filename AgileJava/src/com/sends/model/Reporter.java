package com.sends.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.sends.course.Session;

public class Reporter {

	public static final String NEW_LINE = System.getProperty("line.separator");

	public static final String REPORTER_HEADER = "Student imformation:" + NEW_LINE;

	public static final String REPORTER_FOOTER = NEW_LINE + "--#All Student:";

	private Session session;

	private Writer writer;

	public Reporter(Session course) {

		this.session = course;

	}

	private void writeHeader() throws IOException {
		writer.write(REPORTER_HEADER);
		writer.write(NEW_LINE);
	}

	private void writeBody() throws IOException {
		for (Student student : session.getAllStudent()) {
			writer.write(student.getName());
			writer.write(NEW_LINE);
		}
	}

	private void writeFooter() throws IOException {
		writer.write(REPORTER_FOOTER);
		writer.write(String.valueOf(session.getAllStudent().size()));
	}

	public void getReport(Writer writer) throws IOException {
		// TODO Auto-generated method stub

		this.writer = writer;

		writeHeader();
		writeBody();
		writeFooter();

	}

	public void getReport(String fileName) throws IOException {
		// TODO Auto-generated method stub
		Writer bufferWriter=new BufferedWriter(new FileWriter(fileName));
		
		try {
			getReport(bufferWriter);
		} finally {
			// TODO: handle finally clause
			
			bufferWriter.close();
			
		}
		
	}
	
	public String getReport() throws IOException {
		
		writer = new StringWriter();
		writeHeader();
		writeBody();
		writeFooter();
		return writer.toString();
	}

}
