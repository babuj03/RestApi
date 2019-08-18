package uk.co.telecom.app.repository;

import org.springframework.stereotype.Repository;
import uk.co.telecom.app.domain.Phone;
import uk.co.telecom.app.util.CommonMapper;
import uk.co.telecom.app.util.Messages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PhoneRepository {
    private CommonMapper mapper;
    static List<Phone> phoneList = new ArrayList<>();

    public PhoneRepository(){
        this.mapper = new CommonMapper();
    }

    static {
        phoneList.add(new Phone(1l,"0734334434",true, LocalDate.now(), LocalDate.now(), 11l ));
        phoneList.add(new Phone(2l,"0734334430",false, LocalDate.now(), LocalDate.now(),21l ));
        phoneList.add(new Phone(3l,"0734334431",true, LocalDate.now(), LocalDate.now(), 31l ));
        phoneList.add(new Phone(4l,"0734334432",false, LocalDate.now(), LocalDate.now() , 41l));
    }

    public Optional<Phone> findById(Long phoneId) throws Exception {
        Optional<Phone> phoneFound = phoneList.stream().filter(phone -> phone.getId() == phoneId)
                .findFirst();
        return phoneFound;
    }

    public List<Phone> findAll() {
         return phoneList.stream().collect(Collectors.toList());
    }

    public void activatePhoneById(Long phoneId) throws Exception {
        List<Phone> newPhoneList = phoneList.stream()
                .map(phone -> {
                   if( phone.getId() == phoneId){
                     phone.setActive(true);
                    }
                    return phone;
                })
                .collect(Collectors.toList());
        //Replace update List with old one;
        phoneList =newPhoneList;
    }

    public List<Phone> findPhoneByCustomerId(Long customerId) throws Exception {
            List<Phone> phList =  phoneList.stream()
                .filter(phone-> phone.getCustomerId() == customerId)
                .collect(Collectors.toList());
        return phList;
    }

/*
   public void deleteById(Long id){
        phoneRepository.deleteById(id);
    }
*/

}
