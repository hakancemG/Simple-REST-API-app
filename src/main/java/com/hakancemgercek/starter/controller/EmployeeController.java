package com.hakancemgercek.starter.controller;

import com.hakancemgercek.starter.model.Department;
import com.hakancemgercek.starter.model.Employee;
import com.hakancemgercek.starter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // EmployeeController Class'ının Controller bean'i olarak Spring'e bildirdim.
@RequestMapping("/rest/api/employee") // Class'la alakalı genel bir endpoint belirledim.
public class EmployeeController {

    @Autowired  // gerekli field enjeksiyonu.
    private EmployeeService employeeService;

    @GetMapping("/list") // Tüm çalışan bilgilerini çektiğimiz metot.
    public List<Employee> getAllEmployeeList(){
        return employeeService.getAllEmployeeList();
    }

    @GetMapping("/list/{id}") // id ile belirli bir çalışan verisini çektiğimiz metot.
    public Employee getEmployeeById(@PathVariable(name="id", required = true) String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/with-params") // Parametrede verilen değerlerle veri çektiğimiz metot.
    public List<Employee> getEmployeeWithParams(@RequestParam(name="firstName", required=false) String firstName,
                                                @RequestParam(name="lastName", required=false) String lastName){
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }

    @PostMapping("/save") // Yeni bir çalışan verisi ekleme metodu.
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping("/delete/{id}") // girilen id ile eşleşen çalışanı sildiğimiz metot.
    public boolean deleteEmployeeById(@PathVariable(name="id") String id){
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update/{id}") // girilen id ile eşleşen çalışanı güncellediğimiz metot.
    public Employee updateEmployeeById(@PathVariable(name="id") String id,
                                       @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployeeById(id, updatedEmployee);
    }
}
