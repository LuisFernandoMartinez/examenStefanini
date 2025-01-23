package com.javatechie.jwt.api.controller;

import com.javatechie.jwt.api.entity.EmployeesCompanyBarrilito;
import com.javatechie.jwt.api.service.EmployeesBarrilitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RestController
@RequestMapping("/api/employeesBarrilito")
public class EmployeesBarrilitoController {

    @Autowired
    private EmployeesBarrilitoService personEntityService;

    @GetMapping("/getAll")
    private List<EmployeesCompanyBarrilito> getAllItems() {
        return personEntityService.getAll();
    }

    @GetMapping("/getOne/{id}")
    private EmployeesCompanyBarrilito getById(@PathVariable Long id) {
        return personEntityService.getById(id);
    }

    @PostMapping("/create")
    private EmployeesCompanyBarrilito createAeropuerto(@RequestBody EmployeesCompanyBarrilito personEntity) {
        return personEntityService.create(personEntity);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteById(@PathVariable Long id) {
        personEntityService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    private EmployeesCompanyBarrilito updateAeropuerto(@PathVariable Long id, @RequestBody EmployeesCompanyBarrilito personEntity) {
        EmployeesCompanyBarrilito existing = personEntityService.getById(id);
        if (existing != null) {
            if (personEntity.getNamePerson() != null) {
                existing.setNamePerson(personEntity.getNamePerson());
            }
            if (personEntity.getLastNamePerson() != null) {
                existing.setLastNamePerson(personEntity.getLastNamePerson());
            }
            if (personEntity.getDateBirth() != null) {
                existing.setDateBirth(personEntity.getDateBirth());
            }
            if (personEntity.getJobPosition() != null) {
                existing.setJobPosition(personEntity.getJobPosition());
            }
            if (personEntity.getSalary() != null) {
                existing.setSalary(personEntity.getSalary());
            }
            return personEntityService.create(existing);
        } else {
            throw new IllegalArgumentException("Person with ID " + id + " not found.");
        }
    }


}
