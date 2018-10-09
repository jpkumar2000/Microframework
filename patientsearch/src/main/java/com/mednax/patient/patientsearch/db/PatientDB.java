/**
 * 
 */
package com.mednax.patient.patientsearch.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mednax.patient.patientsearch.model.Patient;

/**
 * @author jpradeepkumar
 *
 */
public class PatientDB {

	/**
	 * 
	 */
	public PatientDB() {
		// TODO Auto-generated constructor stub
	}
	
	public static HashMap<String, Patient> patients = new HashMap<>();
    static{
    	patients.put("1", new Patient("1", "Lokesh", "Gupta", "test@mednax.com"));
    	patients.put("2", new Patient("2", "John", "Gruber", "test@mednax.com"));
    	patients.put("3", new Patient("3", "Melcum", "Marshal", "test@mednax.com"));
    }
     
    public static List<Patient> getPatients(){
        return new ArrayList<Patient>(patients.values());
    }
     
    public static Patient getPatient(String mrn){
        return patients.get(mrn);
    }
     
    public static void updatePatient(String mrn, Patient patient){
    	patients.put(mrn, patient);
    }
     
    public static void removeEmployee(String mrn){
    	patients.remove(mrn);
    }

}
