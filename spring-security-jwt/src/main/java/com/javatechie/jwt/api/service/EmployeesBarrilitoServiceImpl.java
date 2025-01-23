package com.javatechie.jwt.api.service;

import com.javatechie.jwt.api.EmployeesBarrilitoRepository;
import com.javatechie.jwt.api.entity.EmployeesCompanyBarrilito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesBarrilitoServiceImpl implements EmployeesBarrilitoService {

    @Autowired
    private EmployeesBarrilitoRepository repository;

    @Override
    public List<EmployeesCompanyBarrilito> getAll() {
        return ((List<EmployeesCompanyBarrilito>) repository.findAll());
    }

    @Override
    public EmployeesCompanyBarrilito getById(Long id) {
        return repository.findById(id).orElse(null) ;
    }

    @Override
    public EmployeesCompanyBarrilito create(EmployeesCompanyBarrilito personEntity) {
        return repository.save(personEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
