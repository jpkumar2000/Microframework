/**
 * 
 */
package com.mednax.patient.patientsearch.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author jpradeepkumar
 *
 */
public class Patient {


	
	@NotNull(message = "MRN cannot be null/empty")
    private String mrn;
	
    @NotBlank @Length(min=2, max=255)
    private String firstName;
    
    @NotBlank @Length(min=2, max=255)
    private String lastName;
    
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;
     
	/**
	 * 
	 */
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
    public Patient(String mrn, String firstName, String lastName, String email) {
        this.mrn = mrn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
 
    public String getMrn() {
        return mrn;
    }
 
    public void setMrn(String mrn) {
        this.mrn = mrn;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Override
    public String toString() {
        return "Patient [mrn=" + mrn + ", firstName=" + firstName + ", lastName="
                + lastName + ", email=" + email + "]";
    }

}
