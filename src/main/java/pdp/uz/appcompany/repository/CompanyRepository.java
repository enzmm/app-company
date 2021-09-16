package pdp.uz.appcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcompany.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
