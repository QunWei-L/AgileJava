package com.sends.exception;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class StudentHandler extends Handler {

	private LogRecord logRecord;
	
	@Override
	public void publish(LogRecord record) {
		// TODO Auto-generated method stub

		this.logRecord=record;
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws SecurityException {
		// TODO Auto-generated method stub
	}
	public String getMessage(){
		
		return logRecord.getMessage();
	}

}
