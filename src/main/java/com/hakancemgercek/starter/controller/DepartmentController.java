package com.hakancemgercek.starter.controller;

import com.hakancemgercek.starter.model.Department;
import com.hakancemgercek.starter.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // DepartmentController Class'ının Controller bean'i olarak Spring'e bildirdim.
@RequestMapping("/rest/api/department") // Class'la alakalı genel bir endpoint belirledim.
public class DepartmentController {
    @Autowired  // gerekli field enjeksiyonu.
    private DepartmentService departmentService;

    @GetMapping("/list")    // Tüm departman bilgilerini çektiğimiz metot.
    public List<Department> getALlDepartmentList(){return departmentService.getAllDepartmentList();}

    @GetMapping("/list/{id}") // id ile belirli bir departman verisini çektiğimiz metot.
    public Department getDepartmentById(@PathVariable(name="id", required = true) String id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/with-params") // Parametrede verilen değerlerle veri çektiğimiz metot.
    public List<Department> getDepartmentWithParams(@RequestParam(name="id", required = false) String id,
                                                    @RequestParam(name="departmentName", required = false) String departmentName){
        return departmentService.getDepartmentWithParams(id, departmentName);
    }

    @PostMapping("/save") // Yeni bir departman verisi ekleme metodu.
    public Department saveDepartment(@RequestBody Department newDepartment){
        return departmentService.saveDepartment(newDepartment);
    }

    @DeleteMapping("/delete/{id}") // girilen id ile eşleşen maaşı güncellediğimiz metot.
    public boolean deleteDepartmentById(@PathVariable String id){
        return departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/update/{id}") // girilen id ile eşleşen departmanı güncellediğimiz metot.
    public Department updateDepartmentById(@PathVariable(name="id") String id, @RequestBody Department updatedDepartment){
        return departmentService.updateDepartmentById(id, updatedDepartment);
    }
}
