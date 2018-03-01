/**
 * 
 */
package com;

/**
 * @author srichakradhar
 *
 */
public interface IHospitalMgmt {
	
	public int registerDoctor(Doctor d) throws DuplicateDoctorException;
	public int hospitalizePatient(String regNo, Patient p) throws PatientExistException;
	public int releasePatient(int patientId);
	public Doctor retrieveDoctorInfo(int patientId);
	public int patientCountPerCity(String city);

}
