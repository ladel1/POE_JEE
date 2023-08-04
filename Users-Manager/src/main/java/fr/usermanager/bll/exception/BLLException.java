package fr.usermanager.bll.exception;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {

	
	private List<String> errors = new ArrayList<String>();

	public BLLException() {
		// TODO Auto-generated constructor stub
	}
	
	public BLLException(String msg) {
		super(msg);
	}

	public void addError(String error) {
		errors.add(error);
	}

	public List<String> getErrors() {
		return errors;
	}
	
}
