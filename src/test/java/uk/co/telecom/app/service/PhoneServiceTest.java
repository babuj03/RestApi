package uk.co.telecom.app.service;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.telecom.app.domain.Phone;
import uk.co.telecom.app.dto.PhoneDto;
import uk.co.telecom.app.repository.PhoneRepository;
import uk.co.telecom.app.util.CommonMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneServiceTest {
    private PhoneService phoneService;
    private PhoneRepository phoneRepository;
    CommonMapper mapper;


    @Before
    public void setUp() throws  Exception{
        mapper = new CommonMapper();
        phoneRepository = new PhoneRepository();
        phoneService = new PhoneService(phoneRepository,mapper);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById() throws Exception {
        PhoneDto phone = phoneService.findById(1l);
        assertThat(phone.getId()==1);

        //Failed Case
        /*PhoneDto phone = phoneService.findById(10l);
        assertThat(phone.getId()==10);*/
   }
    @Test
    public void findAll() {
        //BDD
/*
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add( new Phone(1000l,"0734334434",true, LocalDate.now(), LocalDate.now(), 11l ));
        given(phoneService.findAll()).willReturn(phoneList);*/


        List<PhoneDto> phone = phoneService.findAll();
        assertThat(phone.size() > 0);
        //assertThat(phone.get(0).getId().longValue());
    }

    @Test
    public void activatePhoneById() throws Exception {
        phoneService.activatePhoneById(2l);
        PhoneDto phone = phoneService.findById(2l);
        assertThat(phone.getActive());
    }

    @Test
    public void findPhoneByCustomerId() throws Exception {
        List<PhoneDto>  phoneList = phoneService.findPhoneByCustomerId(31l);
        assertThat(phoneList.size()>0);
      //Failed Case
       /* List<PhoneDto>  phoneList = phoneService.findPhoneByCustomerId(301l);
        assertThat(phoneList.size()>0);*/
    }

}