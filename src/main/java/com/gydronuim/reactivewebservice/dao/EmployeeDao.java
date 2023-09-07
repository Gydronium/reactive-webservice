package com.gydronuim.reactivewebservice.dao;

import com.gydronuim.reactivewebservice.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


public interface EmployeeDao extends ReactiveMongoRepository<Employee, Integer> {

    @Query("{ 'name': ?0 }")
    Flux<Employee> findByName(final String name);
}
