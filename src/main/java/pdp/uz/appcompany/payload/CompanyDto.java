package pdp.uz.appcompany.payload;

import lombok.Data;

@Data
public class CompanyDto {
    private String corpName;
    private String directorName;
    private String companyAddress;
    private String street;
    private Integer homeNumber;
}
