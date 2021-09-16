package pdp.uz.appcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcompany.entity.Company;
import pdp.uz.appcompany.payload.CompanyDto;
import pdp.uz.appcompany.payload.Result;
import pdp.uz.appcompany.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/api/company")
    public ResponseEntity<List<Company>> getCompany() {
        List<Company> company = companyService.getCompany();
        return ResponseEntity.ok(company);
    }

    @DeleteMapping(value = "/api/company/{companyId}")
    public ResponseEntity<Result> deleteCompany(@PathVariable Integer companyId) {
        Result result = companyService.deleteCompany(companyId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/api/company")
    public ResponseEntity<Result> addCompany(@RequestBody CompanyDto companyDto) {
        Result result = companyService.addCompany(companyDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/company")
    public ResponseEntity<Result> editCompany(@PathVariable Integer companyId, @RequestBody CompanyDto companyDto) {
        Result result = companyService.editCompany(companyId, companyDto);
        return ResponseEntity.ok(result);
    }
}