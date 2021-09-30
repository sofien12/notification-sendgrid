package com.api.sendgrid.notify.unit_tests;

import com.api.sendgrid.notify.service.servicenotify.AccessValidation;
import com.api.sendgrid.notify.service.servicenotify.CheckMail;
import com.api.sendgrid.notify.service.servicenotify.CheckPassword;
import com.api.sendgrid.notify.utils.NotifyExecpion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles= {"test"})
public class notifyTest {


    @InjectMocks
    AccessValidation accessValidation;
    @InjectMocks
    CheckMail checkMail;
    @InjectMocks
    CheckPassword checkPassword;

    String url ="";


    public void init(){
        when(accessValidation.verifyParam("sofien.trabelsi@slashup.studio")).thenReturn(true);
        when(checkMail.verifyParam("sofien.trabelsi@slashup.studio","12345-6789-abcd")).thenReturn(true);
        when(checkPassword.verifyParam("sofien.trabelsi@slashup.studio","12345-6789-abcd")).thenReturn(true);

    }




    @Test
    public void accessValidation() throws NotifyExecpion {
        List<Object> params = new ArrayList<>();
        params.add("sofien.trabelsi@slashup.studio");
        params.add("trabelsi");
        params.add("sofien");
        params.add("Désactivation");
        params.add("Hsi");
        accessValidation.notifyModule(params,"sendgridapikey",url,"templateID");
    }

    @Test
    public void checkMail() throws NotifyExecpion {
        List<Object> params = new ArrayList<>();
        params.add("sofien.trabelsi@slashup.studio");
        params.add("trabelsi");
        params.add("12345-6789-abcd");
        params.add("localhost:3000");
        params.add("Hsi");
        checkMail.notifyModule(params,"sendgridapikey",url,"templateID");
    }

    @Test
    public void checkPassword() throws NotifyExecpion {
        List<Object> params = new ArrayList<>();
        params.add("sofien.trabelsi@slashup.studio");
        params.add("trabelsi");
        params.add("12345-6789-abcd");
        params.add("localhost:3000");
        params.add("Hsi");
        checkPassword.notifyModule(params,"sendgridapikey",url,"templateID");
    }


}
