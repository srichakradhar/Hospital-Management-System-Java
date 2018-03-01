package com;

import java.util.ArrayList;
import java.util.List;
import com.DuplicateDoctorException;

public class HospitalMgmtImpl implements IHospitalMgmt {
	
	List<Doctor> doctorList = new ArrayList<Doctor>();
	
	HospitalMgmtImpl(){
		
	}

	/**
	 * registers (add) one doctor into system.
	Returns size of the list on success. -1 in failed scenario. Doctor regNo
	should be unique unless it should throw DuplicateDoctorException. Exception
	class outline is given at the end.
	 */
	@Override
	public int registerDoctor(Doctor d) throws DuplicateDoctorException {
		
		int doctorListSize = -1;
		
		for(Doctor doc : doctorList) {
			
			if(doc.regNo == d.regNo) {
				throw new DuplicateDoctorException();
			}
			
		}
		
		doctorList.add(d);
		doctorListSize = doctorList.size();
		
		return doctorListSize;
	}
	
	/**
	 * add a patient in the
	treating Doctor’s List identified by the regNo. Returns size of the
	patientList on success. -1 in failed scenario. uId is the unique identifier
	for a Patient (like PAN001). If Patient with same uId is already treated by
	a Doctor, method will throw PatientExistException. Exception class outline
	is given at the end.
	 * @throws PatientExistException 
	 */
	@Override
	public int hospitalizePatient(String regNo, Patient p) throws PatientExistException {
		
		Doctor treatingDoctor = null;
		
		for(Doctor doc : doctorList) {
			
			if(doc.regNo == regNo) {
				treatingDoctor = doc;
			}
			
			for(Patient patient : doc.patientList) {
				if(patient.uId == p.uId) {
					throw new PatientExistException();
				}
			}
		}
		
		if(treatingDoctor != null) treatingDoctor.patientList.add(p);
		
		return treatingDoctor == null ? -1 : treatingDoctor.patientList.size();
	}

	/**
	 * method removes one patient based on patientId
	from system. Returns size of the list after removal if operation is
	successful. -1 in failed scenario.
	 */
	@Override
	public int releasePatient(int patientId) {
		int patientListSize = -1;
		
		for(Doctor doc : doctorList) {
			
			for(Patient patient : doc.patientList) {
				if(patient.patientId == patientId) {
					doc.patientList.remove(patient);
					patientListSize = doc.patientList.size();
					break;
				}
			}
		}
		return patientListSize;
	}

	/**
	 *  returns treating Doctor based on
	patientId from system. Returns Doctor object from List on success. Blank
	Doctor object in failed scenario.
	 */
	@Override
	public Doctor retrieveDoctorInfo(int patientId) {
		Doctor doctor = new Doctor();
		for(Doctor doc : doctorList) {
			
			for(Patient patient : doc.patientList) {
				if(patient.patientId == patientId) {
					doctor = doc;
					break;
				}
			}
		}
		
		return doctor;
	}

	/**
	 * returns count of patients, who are from the specific city given as argument.
	 */
	@Override
	public int patientCountPerCity(String city) {
		int count = 0;
		for(Doctor doc : doctorList) {
			
			for(Patient patient : doc.patientList) {
				if(patient.city == city) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		Patient phani = new Patient("UID1", "Phani", "Hyderabad");
		Patient madhuri = new Patient("UID2", "Madhuri", "Hyderabad");
		Patient anjana = new Patient("UID3", "Anjana", "Vijayawada");
		
		Doctor chakri = new Doctor("1", "Srichakradhar");
		Doctor pradeep = new Doctor("2", "Pradeep");
		
		HospitalMgmtImpl hospital = new HospitalMgmtImpl();
		
		try {
			hospital.registerDoctor(chakri);
			hospital.registerDoctor(pradeep);
		} catch (DuplicateDoctorException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			hospital.hospitalizePatient("1", phani);
			hospital.hospitalizePatient("2", madhuri);
			hospital.hospitalizePatient("2", anjana);
		} catch (PatientExistException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		System.out.println(hospital.retrieveDoctorInfo(1).docName);
		System.out.println(hospital.retrieveDoctorInfo(2).docName);
		System.out.println(hospital.retrieveDoctorInfo(3).docName);
		
		System.out.println(hospital.patientCountPerCity("Hyderabad"));
		System.out.println(hospital.patientCountPerCity("Vijayawada"));
		System.out.println(hospital.patientCountPerCity("Kadapa"));
		
		System.out.println(hospital.releasePatient(1));
		System.out.println(hospital.releasePatient(2));
		System.out.println(hospital.releasePatient(3));
	}

}
