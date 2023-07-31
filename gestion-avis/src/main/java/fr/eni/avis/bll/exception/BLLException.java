package fr.eni.avis.bll.exception;

public class BLLException extends Exception {

	public BLLException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {		
		return "BLL Exception: "+super.getMessage();
	}
	
}
