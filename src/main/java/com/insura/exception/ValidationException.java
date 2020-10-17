package com.insura.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String objectInput;
	private String errorClass;
	private int errorLine;

	public ValidationException(String errorMessage) {
		super(errorMessage);
	}

	public ValidationException(String errorMessage, String objectInput) {
		super(errorMessage);
		this.objectInput = objectInput;
	}

	public ValidationException(String errorMessage, String errorClass, int errorLine) {
		super(errorMessage);
		this.errorClass = errorClass;
		this.errorLine = errorLine;
	}

	public ValidationException(String errorMessage, Throwable e) {
		super(errorMessage, e);
	}

	public String getObjectInput() {
		return this.objectInput;
	}

	public void setObjectInput(String objectInput) {
		this.objectInput = objectInput;
	}

	public String getErrorClass() {
		return errorClass;
	}

	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}

	public int getErrorLine() {
		return errorLine;
	}

	public void setErrorLine(int errorLine) {
		this.errorLine = errorLine;
	}

}
