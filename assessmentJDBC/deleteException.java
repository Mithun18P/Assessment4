package com.thoughtfocus.assessment4;

public class deleteException extends Exception {
	String msg;

	public deleteException(String msg) {
		this.msg = msg;
	}
	public String getmessage() {
		return msg;
	}
	
}
