package uk.co.telecom.app.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.telecom.app.dto.PhoneDto;
import uk.co.telecom.app.service.PhoneService;

import java.util.List;

/**
 * REST controller for managing {@link uk.co.telecom.app.domain.Phone}.
 */
@RestController
@RequestMapping("api/v1/phone")
public class PhoneResource {

    private final Logger log = LoggerFactory.getLogger(PhoneResource.class);

    //@Autowired
    //private PhoneService phoneService;
    // private  CustomerService customerService;

    @Autowired
    PhoneService phoneService;

    public PhoneResource(PhoneService phoneService) {
        this.phoneService = phoneService;

    }

    @GetMapping("/{phoneId}")
    public ResponseEntity<PhoneDto> getPhoneByID(@PathVariable(value = "phoneId" , required = true)  Long phoneId) throws Exception {
        log.debug("REST request to fetch Phone by id ", phoneId);
        if (phoneId == null || phoneId <= 0) {
            throw new Exception("Invalid Phone ID");
           // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id number");
        }
        PhoneDto result = phoneService.findById(phoneId);
        return  ResponseEntity.ok().body(result);
    }

    @PutMapping("/activate/{phoneId}")
    public ResponseEntity<String> updatePhone(@PathVariable(value = "phoneId" , required = true)  Long phoneId) throws Exception {
        log.debug("REST request to activate Phone id" +phoneId);
        phoneService.activatePhoneById(phoneId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/phone-by-customerId/{customerId}")
    public ResponseEntity<List<PhoneDto>>  getPhoneByCustomerId(@PathVariable(value = "customerId" , required = true)  Long customerId) throws Exception {
        log.debug("REST request to get Phones by customer id", customerId);
        List<PhoneDto> phoneDtoList= phoneService.findPhoneByCustomerId(customerId);
        return ResponseEntity.ok().body(phoneDtoList);
    }

    /*@DeleteMapping("/{phoneId}")
    public ResponseEntity<Void> deletePhone(@PathVariable(value = "phoneId" , required = true)  Long phoneId) throws Exception {
        log.debug("REST request to delete Phone : {}", phoneId);
        fakesDAOervice.deleteById(phoneId);
        return ResponseEntity.ok().build();
    }*/
}
