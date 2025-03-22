package com.hakancemgercek.starter.repository;

import com.hakancemgercek.starter.model.Department;
import com.hakancemgercek.starter.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Class'ın Repository olduğunu Spring'e belirttim.
public class EmployeeRepository {
    @Autowired // Gerekli field enjeksiyonunu Spring'e belirttim.
    private List<Employee> employeeList;

    // Tüm verileri döndürecek metot.
    public List<Employee> getAllEmployeeList(){
        return employeeList;
    }

    // Veriyi id'ye göre döndürecek metot.
    public Employee getEmployeeById(String id){
        Employee targetEmployee = null;
        for(Employee employee:employeeList){
            if(id.equals(employee.getId())){
                targetEmployee = employee;
                break;
            }
        }
        return targetEmployee;
    }

    // Girilen parametre ile verileri döndüren metot.
    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        List<Employee> employeeWithParams = new ArrayList<>();
        if(firstName==null && lastName==null){ return employeeList;}
        for(Employee employee:employeeList){
            if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)){
               employeeWithParams.add(employee);
            }
            if(firstName!=null && lastName==null){
                if(employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }
            }
            if(firstName==null && lastName!=null){
                if(employee.getLastName().equalsIgnoreCase(lastName)){
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }

    // yeni bir veri ekleyen metot.
    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    // girilen id'ye göre veriyi silen metot.
    public boolean deleteEmployeeById(String id){
        Employee deleteEmployee = null;
        for(Employee employee:employeeList){
            if(employee.getId().equals(id)){
                deleteEmployee=employee;
                break;
            }
        }
        if(deleteEmployee==null){
            return false;
        }
        employeeList.remove(deleteEmployee);
        return true;
    }

    // girilen id'ye göre veriyi güncelleyen metot.
    public Employee updatedEmployeById(String id, Employee updatedEmployee){
        for(Employee employee:employeeList){
            if(employee.getId().equals(id)){
                employee.setId(updatedEmployee.getId());
                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setLastName(updatedEmployee.getLastName());
            }
        }
        return updatedEmployee;
    }

}
