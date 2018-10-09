package com.mednax.patient.patientsearch;

import io.dropwizard.Application;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mednax.patient.patientsearch.resources.PatientSearchController;

public class AnesthesiaPatientApplication extends Application<AnesthesiaPatientConfiguration> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AnesthesiaPatientApplication.class);

    public static void main(final String[] args) throws Exception {
        new AnesthesiaPatientApplication().run(args);
    }

    @Override
    public String getName() {
        return "AnesthesiaPatient";
    }

    @Override
    public void initialize(final Bootstrap<AnesthesiaPatientConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final AnesthesiaPatientConfiguration configuration,
                    final Environment environment) {
    	
    	LOGGER.info("Registering REST resources");
    	environment.jersey().register(new PatientSearchController(environment.getValidator()));
    	environment.jersey().register(new JsonProcessingExceptionMapper(true));
        // TODO: implement application
    }

}
