package com.hakancemgercek.starter.service;

import com.hakancemgercek.starter.model.Department;
import com.hakancemgercek.starter.model.Employee;
import com.hakancemgercek.starter.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // Class'ın bir service class'ı olduğunu Spring'e bildirdim.
public class EmployeeService {

    @Autowired  //gerekli field enjeksiyonu.
    private EmployeeRepository employeeRepository;

    // Tüm verileri döndürecek metot.
    public List<Employee> getAllEmployeeList(){
        return employeeRepository.getAllEmployeeList();
    }

    // Veriyi id'ye göre döndürecek metot.
    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);
    }

    // Girilen parametre ile verileri döndüren metot.
    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    // yeni bir veri ekleyen metot.
    public Employee saveEmployee(Employee newEmployee){
        return employeeRepository.saveEmployee(newEmployee);
    }

    // girilen id'ye göre veriyi silen metot.
    public boolean deleteEmployeeById(String id){
        return employeeRepository.deleteEmployeeById(id);
    }

    // girilen id'ye göre veriyi güncelleyen metot.
    public Employee updateEmployeeById(String id, Employee updatedEmployee){
        return employeeRepository.updatedEmployeById(id, updatedEmployee);
    }
}
