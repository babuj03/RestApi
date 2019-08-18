package uk.co.telecom.app.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uk.co.telecom.app.domain.Phone;
import uk.co.telecom.app.dto.PhoneDto;

@Component
public class CommonMapper {

        private ModelMapper modelMapper;

        public  CommonMapper() {
                modelMapper = new ModelMapper();
        }
        public  PhoneDto convert(Phone phone) {
                return modelMapper.map(phone, PhoneDto.class);
        }
        public Phone convert(PhoneDto phoneDto) {
                return modelMapper.map(phoneDto, Phone.class);
        }
      /*  public CustomerDto convert(Customer customer) {
                return modelMapper.map(customer, CustomerDto.class);
        }
        public Customer convert(CustomerDto customerDto) {
                return modelMapper.map(customerDto, Customer.class);
        }*/
}