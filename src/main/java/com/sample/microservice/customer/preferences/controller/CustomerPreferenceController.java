package com.sample.microservice.customer.preferences.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sample.microservice.customer.preferences.constants.Constants;
import com.sample.microservice.customer.preferences.model.CustomerPreferencesVO;
import com.sample.microservice.customer.preferences.service.CustomerPreferencesService;

@RestController
@RequestMapping(Constants.DOMAIN + Constants.VERSION)
public class CustomerPreferenceController {
	private static final Logger log = LogManager.getLogger();
	@Autowired
	private CustomerPreferencesService service;

	@Autowired
	private HttpServletRequest request;

	@GetMapping(Constants.HEALTH)
	public String health() {
		return "OK";
	}

	@PostMapping(Constants.CUSTOMER_PREFERENCES)
	public ResponseEntity<?> createCustomerPreferences(@RequestBody CustomerPreferencesVO customerPreferencesVO) {
		long createdResource = service.createCustomerPreferences(customerPreferencesVO);

		return responseEntity201(Constants.PATH_ID, createdResource);
	}

	@PutMapping(Constants.CUSTOMER_PREFERENCES + Constants.PATH_ID)
	public ResponseEntity<?> updateCustomerPreferences(@PathVariable(value = "id") Long customerId,
			@RequestBody CustomerPreferencesVO customerPreferencesVO) {
		service.updateCustomerPreferences(customerId, customerPreferencesVO);

		return responseEntity204();
	}

	@GetMapping(Constants.CUSTOMER_PREFERENCES + Constants.PATH_ID)
	public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") Long customerId) {

		return responseEntity200(service.getCustomerPreferencesById(customerId));
	}

	private ResponseEntity<URI> responseEntity201(String pathParam, Object... pathParamValues) {
		HttpHeaders headers = generateResponseHeaders();
		URI uri = null;
		try {
			uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest().path(pathParam)
					.buildAndExpand(pathParamValues).toUri().getRawPath());
			headers.set("location", uri.toString());
		} catch (URISyntaxException ex) {
			log.error(ex);
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	private ResponseEntity<URI> responseEntity204() {
		HttpHeaders headers = generateResponseHeaders();
		return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
	}
	
	private ResponseEntity<Object> responseEntity200(Object response) {
		HttpHeaders headers = generateResponseHeaders();
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}

	private HttpHeaders generateResponseHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("unique-request-id", request.getHeader("unique-request-id"));
		return headers;
	}

}
