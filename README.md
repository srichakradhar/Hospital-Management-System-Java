# Hospital-Management-System-Java
A simple Hospital Management System in java

### 1.  Create two bean classes with below Class Outline namely Doctor and Patient.

* `patientList` is the list of the Patients attended by the Doctor.

* `addPatient(Patient p)` method receives one Patient object as argument and adds it to the list and returns the current size of the list.

* `releasePatient(Patient p)` method receives int patientId as argument and releases (remove) the patient from the system (list) and returns the current size of the list.


![1](https://user-images.githubusercontent.com/1732922/36937262-ab938f74-1f36-11e8-8c3b-1c074ffc177a.jpg)

`patientId` should be generated using `IDGenerator` class outline as given below. Id value should start with 1.

![2](https://user-images.githubusercontent.com/1732922/36937263-adc39d8e-1f36-11e8-967e-ec2bd35db115.png)

**`Patient` class outline is given below.**

![3](https://user-images.githubusercontent.com/1732922/36937264-b02bbce6-1f36-11e8-98af-2403f8684e50.jpg)

### 2.	Create one Interface with following outline

![4](https://user-images.githubusercontent.com/1732922/36937265-b2dded06-1f36-11e8-850e-6f0b3f5afc10.jpg)

### 3.  Implement interface in HospitalMgmtImpl class as shown in below class outline

![5](https://user-images.githubusercontent.com/1732922/36937266-b53893ee-1f36-11e8-9cfa-aa013590332b.png)

**Property and Method description of the above class is given below**

* doctorList is the list of Doctor present for the Hospital Network (ArrayList)

* registerDoctor(Doctor d) method registers (add) one doctor into system. Returns size of the list on success. -1 in failed scenario. Doctor regNo should be unique unless it should throw DuplicateDoctorException. Exception class outline is given at the end.

* hospitalizePatient(String regNo, Patient p) method add a patient in the treating Doctor’s List identified by the regNo. Returns size of the patientList on success. -1 in failed scenario. uId is the unique identifier for a Patient (like PAN001). If Patient with same uId is already treated by a Doctor, method will throw PatientExistException. Exception class outline is given at the end.

* releasePatient(int patientId) method removes one patient based on patientId from system. Returns size of the list after removal if operation is successful. -1 in failed scenario.

* retrieveDoctorInfo(int patientId) method returns treating Doctor based on patientId from system. Returns Doctor object from List on success. Blank Doctor object in failed scenario.

* patientCountPerCity(String city) method returns count of patients, who are from the specific city given as argument.

**Exception Class Outline is given below**

### 4.  DuplicateDoctorException Class Outline

![6](https://user-images.githubusercontent.com/1732922/36937309-59db6d2c-1f37-11e8-9505-bb860176b06b.png)

Message: Doctor with same Reg No Exist in System

### 5.  PatientExistException Class Outline

![7](https://user-images.githubusercontent.com/1732922/36937310-5bdd9b04-1f37-11e8-89f0-bee99b6c3e77.jpg)

Message: Patient with given PAN already hospitalized
