package com.hakancemgercek.starter.controller;

import com.hakancemgercek.starter.model.Salary;
import com.hakancemgercek.starter.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController // SalaryController Class'ının Controller bean'i olarak Spring'e bildirdim.
@RequestMapping("/rest/api/salary") // Class'la alakalı genel bir endpoint belirledim.
public class SalaryController {
    @Autowired // gerekli field enjeksiyonu.
    private SalaryService salaryService;

    @GetMapping("/list") // Tüm maaş bilgilerini çektiğimiz metot.
    public List<Salary> getAllSalaryList(){
        return salaryService.getAllSalaryList();
    }

    @GetMapping("/list/{id}") // id ile belirli bir maaş verisini çektiğimiz metot.
    public Salary getSalaryById(@PathVariable(name="id", required = true) String id){
        return salaryService.getSalaryById(id);
    }

    @GetMapping("/with-params") // Parametrede verilen değerlerle veri çektiğimiz metot.
    public List<Salary> getSalaryWithParams(@RequestParam(name="id", required = false) String id,
                                            @RequestParam(name="salary", required = false) Long salaryAmount){
        return salaryService.getSalaryWithParams(id, salaryAmount);
    }

    @PostMapping("/save") // Yeni bir maaş verisi ekleme metodu.
    public Salary saveSalary(@RequestBody Salary newSalary){
        return salaryService.saveSalary(newSalary);
    }

    @DeleteMapping("/delete/{id}") // girilen id ile eşleşen maaşı sildiğimiz metot.
    public boolean deleteSalaryById(@PathVariable String id){
        return salaryService.deleteSalaryById(id);
    }

    @PutMapping("/update/{id}") // girilen id ile eşleşen maaşı güncellediğimiz metot.
    public Salary updatedSalaryById(@PathVariable(name="id") String id,
                                    @RequestBody Salary updatedSalary){
        return salaryService.updatedSalaryById(id, updatedSalary);
    }
}
