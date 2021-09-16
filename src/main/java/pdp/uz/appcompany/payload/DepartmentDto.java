package pdp.uz.appcompany.payload;

import lombok.Data;

@Data
public class DepartmentDto {
    private String name;
    private String departmentCompany;
    private String street;
    private Integer homeNumber;
    private Integer companyId;
    private Integer departmentId;
}
