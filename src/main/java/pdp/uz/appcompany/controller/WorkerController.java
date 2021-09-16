package pdp.uz.appcompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcompany.entity.Company;
import pdp.uz.appcompany.entity.Worker;
import pdp.uz.appcompany.payload.CompanyDto;
import pdp.uz.appcompany.payload.Result;
import pdp.uz.appcompany.payload.WorkerDto;
import pdp.uz.appcompany.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    @GetMapping("/api/worker")
    public List<Worker> getWorker() {
        List<Worker> workers = workerService.getWorker();
        return workers;
    }

    @DeleteMapping(value = "/api/worker/{workerId}")
    public Result deleteWorker(@PathVariable Integer workerId) {
        Result result = workerService.deleteWorker(workerId);
        return result;
    }

    @PostMapping("/api/worker")
    public Result addWorker(@RequestBody WorkerDto workerDto) {
        Result result = workerService.addWorker(workerDto);
        return result;
    }

    @PutMapping("/api/worker")
    public Result editWorker(@PathVariable Integer workerId, @RequestBody WorkerDto workerDto) {
        Result result = workerService.editWorker(workerId, workerDto);
        return result;
    }
}
