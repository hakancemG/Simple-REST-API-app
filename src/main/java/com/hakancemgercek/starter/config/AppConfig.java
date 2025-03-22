package com.hakancemgercek.starter.config;

import com.hakancemgercek.starter.model.Department;
import com.hakancemgercek.starter.model.Employee;
import com.hakancemgercek.starter.model.Salary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    // Veritabanı olmadan, 'dummy' verilerle oluşturduğum Listeler

    // Bean olarak Spring context'e eklediğim employee listesi dummy verileri.
    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Hakan Cem","Gerçek"));
        employeeList.add(new Employee("2", "Mazlum","İliş"));
        employeeList.add(new Employee("3", "Melih","Ergün"));
        employeeList.add(new Employee("4", "Avnullah Mansur","Ateş"));
        return employeeList;
    }

    // Bean olarak Spring context'e eklediğim department listesi dummy verileri.
    @Bean
    public List<Department> departmentList(){
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department("1","IT"));
        departmentList.add(new Department("2","HR"));
        departmentList.add(new Department("3","Software Development"));
        departmentList.add(new Department("4","Software Management"));
        return departmentList;
    }


    // Bean olarak Spring context'e eklediğim department listesi dummy verileri.
    @Bean
    public List<Salary> getAllSalaryList(){
        List<Salary> salaryList = new ArrayList<>();
        salaryList.add(new Salary("1",30000L));
        salaryList.add(new Salary("2",4500000L));
        salaryList.add(new Salary("3",1200000L));
        salaryList.add(new Salary("4",7025000L));

        return salaryList;
    }
}
