package pdp.uz.appcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcompany.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
