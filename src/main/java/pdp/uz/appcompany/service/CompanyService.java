package pdp.uz.appcompany.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcompany.entity.Address;
import pdp.uz.appcompany.entity.Company;
import pdp.uz.appcompany.payload.CompanyDto;
import pdp.uz.appcompany.payload.Result;
import pdp.uz.appcompany.repository.AddressRepository;
import pdp.uz.appcompany.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping
    public List<Company> getCompany(){
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    @DeleteMapping(value = "/api/company/{companyId}")
    public Result deleteCompany(@PathVariable Integer companyId){
        companyRepository.deleteById(companyId);
        return new Result("deleted",true);
    }

    @PostMapping
    public Result addCompany(@RequestBody CompanyDto companyDto) {
        Address address = new Address();
        address.setHomeNumber(companyDto.getHomeNumber());
        address.setStreet(companyDto.getStreet());
        Address savedAddress = addressRepository.save(address);

        Company company = new Company();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        company.setCompanyAddress(companyDto.getCompanyAddress());
        company.setAddress(savedAddress);
        companyRepository.save(company);

        return new Result("Qo'shildi",true);

    }

    @PutMapping()
    public Result editCompany(@PathVariable Integer id, @RequestBody CompanyDto companyDto) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setCorpName(companyDto.getCorpName());
            company.setDirectorName(companyDto.getDirectorName());
            company.setCompanyAddress(companyDto.getCompanyAddress());
            companyRepository.save(company);

            Address address = company.getAddress();
            address.setStreet(companyDto.getStreet());
            address.setHomeNumber(companyDto.getHomeNumber());
            addressRepository.save(address);

            return new Result(" edited",true);
        }
        return new Result("not found", false);
    }
}
