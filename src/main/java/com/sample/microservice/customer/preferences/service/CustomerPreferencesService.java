package com.sample.microservice.customer.preferences.service;

import com.sample.microservice.customer.preferences.model.CustomerPreferencesVO;

public interface CustomerPreferencesService {
	long createCustomerPreferences(CustomerPreferencesVO customerPreferencesVO);
	
	void updateCustomerPreferences(long id, CustomerPreferencesVO customerPreferencesVO);
	
	CustomerPreferencesVO getCustomerPreferencesById(long id);

}
