package pdp.uz.appcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcompany.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
