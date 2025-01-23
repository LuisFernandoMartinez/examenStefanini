package com.javatechie.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees_company_barrilito")
public class EmployeesCompanyBarrilito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_person")
    private String namePerson;
    @Column(name = "lastname_person")
    private String lastNamePerson;
    @Column(name = "d_Birth")
    private LocalDate dateBirth;
    @Column(name = "job_position")
    private String jobPosition;
    @Column(name = "person_salary")
    private Double salary;

    public EmployeesCompanyBarrilito(String namePerson, String lastNamePerson, LocalDate  dateBirth, String jobPosition, Double salary) {
        this.namePerson = namePerson;
        this.lastNamePerson = lastNamePerson;
        this.dateBirth = dateBirth;
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getLastNamePerson() {
        return lastNamePerson;
    }

    public void setLastNamePerson(String lastNamePerson) {
        this.lastNamePerson = lastNamePerson;
    }

    public LocalDate  getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate  dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
