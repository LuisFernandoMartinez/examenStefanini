package com.javatechie.jwt.api.service;

import com.javatechie.jwt.api.entity.EmployeesCompanyBarrilito;

import java.util.List;

public interface EmployeesBarrilitoService {
    List<EmployeesCompanyBarrilito> getAll();
    EmployeesCompanyBarrilito getById(Long id);
    EmployeesCompanyBarrilito create(EmployeesCompanyBarrilito personEntity);
    void deleteById(Long id);
}
