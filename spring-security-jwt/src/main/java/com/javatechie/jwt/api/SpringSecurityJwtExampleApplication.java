package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.EmployeesCompanyBarrilito;
import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

    @Autowired
    private EmployeesBarrilitoRepository barrilitoRepository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "LuisMtz", "password", "luis.martinez@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);


        EmployeesCompanyBarrilito per1=new EmployeesCompanyBarrilito("Luis","Martinez", LocalDate.of(1995,8,17),"Developer",20000.0);
        EmployeesCompanyBarrilito per2=new EmployeesCompanyBarrilito("Jorge","Lopez",LocalDate.of(1990,10,29),"QA",30000.0);
        barrilitoRepository.saveAll(Arrays.asList(per1, per2));

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
