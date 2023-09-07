package com.gydronuim.reactivewebservice.application;

import com.gydronuim.reactivewebservice.dao.EmployeeDao;
import com.gydronuim.reactivewebservice.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {

    private final EmployeeDao employeeDao;

    public void create(Employee e) {
        employeeDao.save(e).subscribe();
    }

    public Mono<Employee> findById(Integer id) {
        return employeeDao.findById(id);
    }

    public Flux<Employee> findByName(String name) {
        return employeeDao.findByName(name);
    }

    public Flux<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Mono<Employee> update(Employee e) {
        return employeeDao.save(e);
    }

    public Mono<Void> delete(Integer id) {
        return employeeDao.deleteById(id);
    }
}
