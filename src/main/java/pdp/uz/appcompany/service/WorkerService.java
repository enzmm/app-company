package pdp.uz.appcompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcompany.entity.Company;
import pdp.uz.appcompany.entity.Worker;
import pdp.uz.appcompany.payload.CompanyDto;
import pdp.uz.appcompany.payload.Result;
import pdp.uz.appcompany.payload.WorkerDto;
import pdp.uz.appcompany.repository.DepartmentRepository;
import pdp.uz.appcompany.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping
    public List<Worker> getWorker(){
        List<Worker> workers = workerRepository.findAll();
        return workers;
    }

    @DeleteMapping
    public Result deleteWorker(@PathVariable Integer workerId){
        workerRepository.deleteById(workerId);
        return new Result("delete",true);
    }

    @PostMapping
    public Result addWorker(@RequestBody WorkerDto workerDto){
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setWorkerDepartment(workerDto.getWorkerDepartment());
        worker.setAddress(workerDto.getAddress());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        worker.setDepartment( departmentRepository.findById(workerDto.getDepartmentId()).get());
        workerRepository.save(worker);
        return new Result("add",true);
    }

    @PutMapping()
    public Result editWorker(@PathVariable Integer id, @RequestBody WorkerDto workerDto){
        Optional<Worker> optionalWorker = workerRepository.findById(workerDto.getWorkerId());
        if (optionalWorker.isPresent()) {
            Worker worker = optionalWorker.get();
            worker.setName(workerDto.getName());
            worker.setWorkerDepartment(workerDto.getWorkerDepartment());
            worker.setPhoneNumber(workerDto.getPhoneNumber());
            worker.setAddress(workerDto.getAddress());
            workerRepository.save(worker);
        }
        return new Result("edit",true);
    }

    }


