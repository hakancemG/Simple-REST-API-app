package com.hakancemgercek.starter.service;

import com.hakancemgercek.starter.model.Salary;
import com.hakancemgercek.starter.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service    // Class'ın bir service class'ı olduğunu Spring'e bildirdim.
public class SalaryService {

    @Autowired  //gerekli field enjeksiyonu.
    private SalaryRepository salaryRepository;

    // Tüm verileri döndürecek metot.
    public List<Salary> getAllSalaryList(){
        return salaryRepository.getAllSalaryList();
    }

    // Veriyi id'ye göre döndürecek metot.
    public Salary getSalaryById(String id){
        return salaryRepository.getSalaryById(id);
    }

    // Girilen parametre ile verileri döndüren metot.
    public List<Salary> getSalaryWithParams(String id, Long salaryAmount){
        return salaryRepository.getSalaryWithParams(id, salaryAmount);
    }

    // yeni bir veri ekleyen metot.
    public Salary saveSalary(Salary newSalary){
        return salaryRepository.saveSalary(newSalary);
    }

    // girilen id'ye göre veriyi silen metot.
    public boolean deleteSalaryById(String id){
        return salaryRepository.deleteSalaryById(id);
    }

    // girilen id'ye göre veriyi güncelleyen metot.
    public Salary updatedSalaryById(String id, Salary updatedSalary){
        return salaryRepository.updatedSalaryById(id, updatedSalary);
    }
}
