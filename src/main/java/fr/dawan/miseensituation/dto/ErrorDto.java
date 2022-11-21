package fr.dawan.miseensituation.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ErrorDto implements Serializable {

	private int errorCode;
	private String message;
	private String path;
	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
