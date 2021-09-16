package pdp.uz.appcompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcompany.entity.Company;
import pdp.uz.appcompany.entity.Department;
import pdp.uz.appcompany.payload.CompanyDto;
import pdp.uz.appcompany.payload.DepartmentDto;
import pdp.uz.appcompany.payload.Result;
import pdp.uz.appcompany.repository.CompanyRepository;
import pdp.uz.appcompany.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping
    public List<Department> getDepartment(){
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @DeleteMapping(value = "/api/department/{departmentId}")
    public Result deleteDepartment(@PathVariable Integer departmentId){
        departmentRepository.deleteById(departmentId);
        return new Result("delete",true);
    }

    @PostMapping
    public Result addDepartment(@RequestBody DepartmentDto departmentDto){
        Department department1 = new Department();
        department1.setName(departmentDto.getName());
        department1.setDepartmentCompany(departmentDto.getDepartmentCompany());
        department1.setStreet(departmentDto.getStreet());
        department1.setHomeNumber(departmentDto.getHomeNumber());
        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
        if (!optionalCompany.isPresent()) {
            return new Result("not found",false);
        }
        department1.setCompany(optionalCompany.get());
        departmentRepository.save(department1);
        return new Result("added",true);
    }

    @PutMapping()
    public Result editDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto){
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department department1 = optionalDepartment.get();
            department1.setName(departmentDto.getName());
            department1.setDepartmentCompany(departmentDto.getDepartmentCompany());
            department1.setStreet(departmentDto.getStreet());
            department1.setHomeNumber(departmentDto.getHomeNumber());
            Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompanyId());
            if (!optionalCompany.isPresent()) {
                return new Result("Company not found",false);
            }
            department1.setCompany(optionalCompany.get());
            departmentRepository.save(department1);
            return new Result("edited",true);
        }
        return new Result("Department not found",false);
    }
    }


