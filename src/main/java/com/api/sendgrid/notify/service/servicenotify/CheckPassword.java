package com.api.sendgrid.notify.service.servicenotify;
/**
 * this class consists exclusively of void and boolean methods
 * which work to send notifications by email to the user  for
 * change password
 *
 * @author Sofien Trabelsi
 * @version 1.0
 */
import com.api.sendgrid.notify.entity.dto.*;
import com.api.sendgrid.notify.service.servicemessage.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import studio.slashup.iosis.notify.entity.dto.*;

import com.api.sendgrid.notify.utils.NotifyExecpion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
@Service
public class CheckPassword implements NotifyService {


    Logger logger = LogManager.getLogger(CheckPassword.class);

    @Autowired
    private Environment environment;


    @Autowired
    private MessageService mailSendgrid;

    @Value("${url}")
    private String url;

    @Value("${emailKoors}")
    private String emailKoors ;

    @Value("${nameKoors}")
    private String nameKoors ;


    /**
     *this method allows to test the email address and token  is valid or not
     * @param mail
     * @return
     */
    public boolean verifyParam(String mail, String token) {
         String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(mail).matches() && token != null;
    }


    /**
     * this method consists exclusively
     * which work to send notifications by email to the user  for
     * change password
     * @param param
     * @param sendgrid
     * @param urll
     * @throws NotifyExecpion
     */
    @Override
    public void notifyModule( List<Object> param , String sendgrid , String urll , String templateId) throws NotifyExecpion {
        if (!verifyParam((String) param.get(0), (String) param.get(3)))
            throw new NotifyExecpion("Paramétres non conformes");
        else {
            MailingDto mailingDto = mailingDto(param,templateId ,"url1") ;
            mailSendgrid.send(mailingDto);
            logger.info("send Email to {}", param.get(0));
        }
    }

    /**
     * this methode consists to create Object MailingDto
     * @param param
     * @param templateId
     * @param url
     * @return
     */
    private MailingDto mailingDto(List<Object> param , String templateId , String url){
        DynamicTemplateData dynamicTemplateData = new DynamicTemplateData(param.get(1).toString()," Réinitialisation de mot de passe",url);
        Gender gender = new Gender();        if(!param.get(2).toString().equals("")){
            if(param.get(2).toString().equals("MALE"))
                gender.setMale(true);
            else
                gender.setFemme(true);
        }

        dynamicTemplateData.setGender(gender);
        List<To> tos = new ArrayList<>();
        tos.add( new To(param.get(0).toString(),param.get(1).toString()));
        List<Personalization> personalizations = new ArrayList<>() ;
        personalizations.add( new Personalization(tos,dynamicTemplateData));
        return new MailingDto(new From(emailKoors,nameKoors),personalizations , templateId) ;
    }
}
