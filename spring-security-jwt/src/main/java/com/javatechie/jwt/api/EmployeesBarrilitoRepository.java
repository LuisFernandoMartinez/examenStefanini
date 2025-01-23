package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.EmployeesCompanyBarrilito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesBarrilitoRepository extends
        CrudRepository<EmployeesCompanyBarrilito,Long> {

}
