package com.hakancemgercek.starter.repository;

import com.hakancemgercek.starter.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository // Class'ın Repository olduğunu Spring'e belirttim.
public class SalaryRepository {
    @Autowired // Gerekli field enjeksiyonunu Spring'e belirttim.
    private List<Salary> salaryList;

    // Tüm verileri döndürecek metot.
    public List<Salary> getAllSalaryList(){
        return salaryList;
    }

    // Veriyi id'ye göre döndürecek metot.
    public Salary getSalaryById(String id){
        Salary targetSalary = null;
        for(Salary salary: salaryList){
            if(id.equals(salary.getId())){
                targetSalary=salary;
                break;
            }
        }
        return targetSalary;
    }

    // Girilen parametre ile verileri döndüren metot.
    public List<Salary> getSalaryWithParams(String id, Long salaryAmount){
        List<Salary> salaryWithParams = new ArrayList<>();
        if(id==null && salaryAmount==null){
            return salaryList;
        }
        for(Salary salary:salaryList){
            if(Objects.equals(salary.getId(), id) && Objects.equals(salary.getSalaryAmount(), salaryAmount)){
                salaryWithParams.add(salary);
            }
            if(id!=null && salaryAmount==null){
                if(salary.getId().equalsIgnoreCase(id)){
                    salaryWithParams.add(salary);
                }
            }
            if(id==null && salaryAmount!=null){
                if(Objects.equals(salary.getSalaryAmount(), salaryAmount)){
                    salaryWithParams.add(salary);
                }
            }
        }
        return salaryWithParams;
    }

    // yeni bir veri ekleyen metot.
    public Salary saveSalary(Salary newSalary){
        salaryList.add(newSalary);
        return newSalary;
    }

    // girilen id'ye göre veriyi silen metot.
    public boolean deleteSalaryById(String id){
        Salary deleteSalary = null;
        for(Salary salary:salaryList){
            if(salary.getId().equals(id)){
                deleteSalary=salary;
                break;
            }
        }
        if(deleteSalary==null){
            return false;
        }
        salaryList.remove(deleteSalary);
        return true;
    }

    // girilen id'ye göre veriyi güncelleyen metot.
    public Salary updatedSalaryById(String id, Salary updatedSalary){
        for(Salary salary:salaryList){
            if(salary.getId().equals(id)){
                salary.setId(updatedSalary.getId());
                salary.setSalaryAmount(updatedSalary.getSalaryAmount());
            }
        }
        return updatedSalary;
    }
}
