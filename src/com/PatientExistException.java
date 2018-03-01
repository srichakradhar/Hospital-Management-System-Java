package com;

public class PatientExistException extends Exception {

	long serialVersionUID;

	public String getMessage() {
		return "Patient with given PAN already hospitalized";
	}
}
