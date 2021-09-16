package pdp.uz.appcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.appcompany.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
