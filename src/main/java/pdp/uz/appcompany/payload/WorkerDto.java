package pdp.uz.appcompany.payload;

import lombok.Data;

@Data
public class WorkerDto {

    private String name;
    private String phoneNumber;
    private String address;
    private String workerDepartment;
    private Integer departmentId;
    private Integer workerId;
}
