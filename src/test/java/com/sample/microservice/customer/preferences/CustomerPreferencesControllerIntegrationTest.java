package com.sample.microservice.customer.preferences;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.microservice.customer.preferences.constants.Constants;
import com.sample.microservice.customer.preferences.model.CustomerPreferencesVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerPreferencesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerPreferencesControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}
	
	@Test
	public void testGetCustomerPreferencesById() {
		long id = 1;
		CustomerPreferencesVO customerPreferencesVO = restTemplate.getForObject(getRootUrl() + Constants.DOMAIN + Constants.VERSION+ Constants.CUSTOMER_PREFERENCES + "/"+id, CustomerPreferencesVO.class);
		assertNotNull(customerPreferencesVO);
	}
	
	@Test
	public void testCreateCustomerPreferences() {
		CustomerPreferencesVO customerPreferencesVO = new CustomerPreferencesVO();
		customerPreferencesVO.setEmailId("jaycmca@gmail.com");
		customerPreferencesVO.setFirstName("admin");
		customerPreferencesVO.setLastName("admin");
		customerPreferencesVO.setPhoneNumber("+971123123123");
		customerPreferencesVO.setPostalAddress("Sharjah,UAE");

		ResponseEntity<CustomerPreferencesVO> postResponse = restTemplate.postForEntity(getRootUrl() + Constants.DOMAIN + Constants.VERSION+ Constants.CUSTOMER_PREFERENCES, customerPreferencesVO, CustomerPreferencesVO.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getHeaders().getLocation());
	}

	@Test
	public void testUpdateCustomerPreferences() {
		int id = 8;
		CustomerPreferencesVO customerPreferencesVO = restTemplate.getForObject(getRootUrl() + Constants.DOMAIN + Constants.VERSION+ Constants.CUSTOMER_PREFERENCES + "/"+id, CustomerPreferencesVO.class);
		customerPreferencesVO.setFirstName("jayakumar");
		customerPreferencesVO.setLastName("chinnamuthu");

		restTemplate.put(getRootUrl() +Constants.DOMAIN + Constants.VERSION+ Constants.CUSTOMER_PREFERENCES+"/" + id, customerPreferencesVO);

		CustomerPreferencesVO getResponse = restTemplate.getForObject(getRootUrl() + Constants.DOMAIN + Constants.VERSION+ Constants.CUSTOMER_PREFERENCES  +"/"+ id, CustomerPreferencesVO.class);
		assertNotNull(getResponse.getFirstName());
		assertEquals("jayakumar", getResponse.getFirstName());
	}
	
}
