package com.sample.microservice.customer.preferences.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.microservice.customer.preferences.entity.CustomerPreferences;
import com.sample.microservice.customer.preferences.model.CustomerPreferencesVO;
import com.sample.microservice.customer.preferences.repository.CustomerPreferencesRepository;

@Service
public class CustomerPreferencesServiceImpl implements CustomerPreferencesService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private CustomerPreferencesRepository repository;

	@Override
	public long createCustomerPreferences(CustomerPreferencesVO customerPreferencesVO) {
		CustomerPreferences pre = repository.save(buildCustomerPreferences(customerPreferencesVO));
		return pre.getId();
	}

	private CustomerPreferences buildCustomerPreferences(CustomerPreferencesVO customerPreferencesVO) {
		CustomerPreferences customerPreferences = new CustomerPreferences();
		customerPreferences.setFirstName(customerPreferencesVO.getFirstName());
		customerPreferences.setLastName(customerPreferencesVO.getLastName());
		customerPreferences.setEmailId(customerPreferencesVO.getEmailId());
		customerPreferences.setPostalAddress(customerPreferencesVO.getPostalAddress());
		customerPreferences.setPhoneNumber(customerPreferencesVO.getPhoneNumber());
		return customerPreferences;
	}

	private CustomerPreferences buildCustomerPreferences(CustomerPreferences customerPreferences,
			CustomerPreferencesVO customerPreferencesVO) {
		if (customerPreferencesVO.getFirstName() != null)
			customerPreferences.setFirstName(customerPreferencesVO.getFirstName());
		if (customerPreferencesVO.getLastName() != null)
			customerPreferences.setLastName(customerPreferencesVO.getLastName());
		if (customerPreferencesVO.getEmailId() != null)
			customerPreferences.setEmailId(customerPreferencesVO.getEmailId());
		if (customerPreferencesVO.getPostalAddress() != null)
			customerPreferences.setPostalAddress(customerPreferencesVO.getPostalAddress());
		if (customerPreferencesVO.getPhoneNumber() != null)
			customerPreferences.setPhoneNumber(customerPreferencesVO.getPhoneNumber());
		return customerPreferences;
	}

	private CustomerPreferencesVO buildCustomerPreferencesVO(CustomerPreferences customerPreferences) {
		CustomerPreferencesVO customerPreferencesVO = new CustomerPreferencesVO();
		if (customerPreferences.getFirstName() != null)
			customerPreferencesVO.setFirstName(customerPreferences.getFirstName());
		if (customerPreferences.getLastName() != null)
			customerPreferencesVO.setLastName(customerPreferences.getLastName());
		if (customerPreferences.getEmailId() != null)
			customerPreferencesVO.setEmailId(customerPreferences.getEmailId());
		if (customerPreferences.getPostalAddress() != null)
			customerPreferencesVO.setPostalAddress(customerPreferences.getPostalAddress());
		if (customerPreferences.getPhoneNumber() != null)
			customerPreferencesVO.setPhoneNumber(customerPreferences.getPhoneNumber());
		return customerPreferencesVO;
	}

	@Override
	public void updateCustomerPreferences(long id, CustomerPreferencesVO customerPreferencesVO) {
		Optional<CustomerPreferences> pre = repository.findById(id);

		if (pre == null) {
			log.error("id does not exist!");
		}
		repository.save(buildCustomerPreferences(pre.get(), customerPreferencesVO));
	}

	@Override
	public CustomerPreferencesVO getCustomerPreferencesById(long id) {
		Optional<CustomerPreferences> pre = repository.findById(id);
		if (pre == null) {
			log.error("id does not exist!");
		}
		return buildCustomerPreferencesVO(pre.get());
	}

}
