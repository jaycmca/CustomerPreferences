package com.sample.microservice.customer.preferences.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.microservice.customer.preferences.entity.CustomerPreferences;

@Repository
public interface CustomerPreferencesRepository extends JpaRepository<CustomerPreferences, Long>{

}
