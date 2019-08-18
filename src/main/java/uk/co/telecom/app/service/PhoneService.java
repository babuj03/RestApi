package uk.co.telecom.app.service;

import org.springframework.stereotype.Service;
import uk.co.telecom.app.domain.Phone;
import uk.co.telecom.app.dto.PhoneDto;
import uk.co.telecom.app.exception.IdNotFoundException;
import uk.co.telecom.app.repository.PhoneRepository;
import uk.co.telecom.app.util.CommonMapper;
import uk.co.telecom.app.util.Messages;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    private CommonMapper mapper;

    public PhoneService(PhoneRepository phoneRepository, CommonMapper mapper)  {
        this.phoneRepository = phoneRepository;
        this.mapper =mapper;
    }

    public PhoneDto findById(Long phoneId) throws Exception {
        Optional<Phone> phone = phoneRepository.findById(phoneId);
        if(phone.isPresent()) {
            return  mapper.convert(phone.get());
        }
        throw new IdNotFoundException(Messages.PHONE_ID_NOT_FOUND);
    }

    public List<PhoneDto> findAll() {
        PhoneDto phoneDto = new PhoneDto();
        List<Phone> phoneList = phoneRepository.findAll();
        List<PhoneDto> phoneDtosList =  phoneList.stream()
                .filter(Objects::nonNull)
                .map(mapper::convert)
                .collect(Collectors.toList());
        return phoneDtosList;
    }
/*
    public void deleteById(Long id){
        phoneRepository.deleteById(id);
    }*/

    public void activatePhoneById(Long phoneId) throws Exception {
        PhoneDto phoneDto = new PhoneDto();
        Optional<Phone>  phone =phoneRepository.findById(phoneId);
        if(phone.isPresent()){
            phoneRepository.activatePhoneById(phoneId);
        }else {
            throw new IdNotFoundException(Messages.PHONE_ID_NOT_FOUND);
        }
    }

    public List<PhoneDto> findPhoneByCustomerId(Long customerId) throws Exception {
         List<Phone> phoneList = phoneRepository.findPhoneByCustomerId(customerId);
        if(phoneList==null || phoneList.isEmpty()){
            throw new IdNotFoundException(Messages.CUSTOMER_ID_NOT_FOUND);
        }
        List<PhoneDto> phoneDtosList =  phoneList.stream()
                .filter(Objects::nonNull)
                .map(mapper::convert)
                .collect(Collectors.toList());
        return phoneDtosList;
    }


}
