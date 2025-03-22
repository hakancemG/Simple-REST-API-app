package com.hakancemgercek.starter.repository;

import com.hakancemgercek.starter.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // Class'ın Repository olduğunu Spring'e belirttim.
public class DepartmentRepository {
    @Autowired // Gerekli field enjeksiyonunu Spring'e belirttim.
    private List<Department> departmentList;

    // Tüm verileri döndürecek metot.
    public List<Department> getAllDepartmentList(){
        return departmentList;
    }

    // Veriyi id'ye göre döndürecek metot.
    public Department getDepartmentById(String id){
        Department targetDepartment = null;
        for(Department department: departmentList){
            if(id.equals(department.getId())){
                targetDepartment=department;
                break;
            }
        }
        return targetDepartment;
    }

    // Girilen parametre ile verileri döndüren metot.
    public List<Department> getDepartmentWithParams(String id, String departmentName){
        List<Department> departmentWithParams = new ArrayList<>();
        if(id==null && departmentName==null){ return departmentList; }
        for(Department department:departmentList){
            if(department.getId().equalsIgnoreCase(id) && department.getDepartmentName().equalsIgnoreCase(departmentName)){
                departmentWithParams.add(department);
            }
            if(id!=null && departmentName==null){
                if(department.getId().equalsIgnoreCase(id)){
                    departmentWithParams.add(department);
                }
            }
            if(id==null && departmentName!=null){
                if(department.getDepartmentName().equalsIgnoreCase(departmentName)){
                    departmentWithParams.add(department);
                }
            }
        }
        return departmentWithParams;
    }

    // yeni bir veri ekleyen metot.
    public Department saveDepartment(Department newDepartment){
        departmentList.add(newDepartment);
        return newDepartment;
    }

    // girilen id'ye göre veriyi silen metot.
    public boolean deleteDepartmentById(String id){
        Department deleteDepartment = null;
        for(Department department:departmentList){
            if(department.getId().equals(id)){
                deleteDepartment=department;
                break;
            }
        }
        if(deleteDepartment==null){
            return false;
        }
        departmentList.remove(deleteDepartment);
        return true;
    }

    // girilen id'ye göre veriyi güncelleyen metot.
    public Department updateDepartmentById(String id, Department updatedDepartment){
        for(Department department: departmentList){
            if(department.getId().equals(id)){
                department.setId(updatedDepartment.getId());
                department.setDepartmentName(updatedDepartment.getDepartmentName());
            }
        }
        return updatedDepartment;
    }
}
