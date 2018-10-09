/**
 * 
 */
package com.mednax.patient.patientsearch.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.validation.ConstraintViolation;

import com.mednax.patient.patientsearch.AnesthesiaPatientApplication;
import com.mednax.patient.patientsearch.db.PatientDB;
import com.mednax.patient.patientsearch.model.Patient;

/**
 * @author jpradeepkumar
 *
 */

@Path("/patientsearch")
@Produces(MediaType.APPLICATION_JSON)
public class PatientSearchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientSearchController.class);
	
	 private final Validator validator;

	/**
	 * 
	 */
	public PatientSearchController(Validator validator) {
		// TODO Auto-generated constructor stub
		LOGGER.info("Calling Constructor");
		this.validator = validator;
	}
	
	 @GET
	 public Response getPatients() {
		   LOGGER.info("Calling Get All Patient Method");
	       return Response.ok(PatientDB.getPatients()).build();
	 }
	
	@GET
    @Path("/{mrn}")
    public Response getPatientByMrn(@PathParam("mrn") String mrn) {
		LOGGER.info("Calling Get Patient by MRN");
		Patient patient = PatientDB.getPatient(mrn);
        if (patient != null)
            return Response.ok(patient).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }
	
	@PUT
	@Path("/{mrn}")
	public Response updateEmployee(@PathParam("mrn") String mrn,Patient patient) throws URISyntaxException {
		LOGGER.info("Calling Update Patient by MRN");
       
		// validation
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        Patient e = PatientDB.getPatient(patient.getMrn());
        
        if (violations.size() > 0) {
            
        	ArrayList<String> validationMessages = new ArrayList<String>();
            
            for (ConstraintViolation<Patient> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        
        if (e != null) {
        	PatientDB.updatePatient(patient.getMrn(), patient);
        	return Response.ok(patient).build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }

}
