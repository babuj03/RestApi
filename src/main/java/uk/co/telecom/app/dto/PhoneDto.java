package uk.co.telecom.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Setter
@ToString
@Getter
public class PhoneDto implements Serializable {
    private Long id;

    private String phone;

    private Boolean active;

    private LocalDate createDate;

    private LocalDate updateDate;

    private  Long customerId ;
//    private CustomerDto customer;


}
