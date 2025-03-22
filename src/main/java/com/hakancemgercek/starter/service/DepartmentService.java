package com.hakancemgercek.starter.service;

import com.hakancemgercek.starter.model.Department;
import com.hakancemgercek.starter.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service    // Class'ın bir service class'ı olduğunu Spring'e bildirdim.
public class DepartmentService {

    @Autowired  //gerekli field enjeksiyonu.
    private DepartmentRepository departmentRepository;

    // Tüm verileri döndürecek metot.
    public List<Department> getAllDepartmentList(){
        return departmentRepository.getAllDepartmentList();
    }

    // Veriyi id'ye göre döndürecek metot.
    public Department getDepartmentById(String id){
        return departmentRepository.getDepartmentById(id);
    }

    // Girilen parametre ile verileri döndüren metot.
    public List<Department> getDepartmentWithParams(String id, String departmentName){
        return departmentRepository.getDepartmentWithParams(id, departmentName);
    }

    // yeni bir veri ekleyen metot.
    public Department saveDepartment(Department newDepartment){
        return departmentRepository.saveDepartment(newDepartment);
    }

    // girilen id'ye göre veriyi silen metot.
    public boolean deleteDepartmentById(String id){
        return departmentRepository.deleteDepartmentById(id);
    }

    // girilen id'ye göre veriyi güncelleyen metot.
    public Department updateDepartmentById(String id, Department updatedDepartment){
        return departmentRepository.updateDepartmentById(id, updatedDepartment);
    }
}
