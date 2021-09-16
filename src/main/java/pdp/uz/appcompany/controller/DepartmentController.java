package pdp.uz.appcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcompany.entity.Company;
import pdp.uz.appcompany.entity.Department;
import pdp.uz.appcompany.payload.CompanyDto;
import pdp.uz.appcompany.payload.DepartmentDto;
import pdp.uz.appcompany.payload.Result;
import pdp.uz.appcompany.service.CompanyService;
import pdp.uz.appcompany.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/api/department")
    public List<Department> getCompany() {
        List<Department> departments = departmentService.getDepartment();
        return departments;
    }

    @DeleteMapping(value = "/api/department/{departmentId}")
    public Result deleteDepartment(@PathVariable Integer departmentId) {
        Result result = departmentService.deleteDepartment(departmentId);
        return result;
    }

    @PostMapping("/api/department")
    public Result addDepartment(@RequestBody DepartmentDto departmentDto) {
        Result result = departmentService.addDepartment(departmentDto);
        return result;
    }

    @PutMapping public Result editDepartment(@PathVariable Integer departmentId, @RequestBody DepartmentDto departmentDto) {
        Result result = departmentService.editDepartment(departmentId, departmentDto);
        return result;
    }
}
