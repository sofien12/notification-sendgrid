package com.api.sendgrid.notify.service.servicenotify;
/**
 * this class consists exclusively of void and boolean methods
 * which work to send notifications by email to the User for
 * Activation Account
 * @author Sofien Trabelsi
 * @version 1.0
 */

import com.api.sendgrid.notify.entity.dto.*;
import com.api.sendgrid.notify.service.servicemessage.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.api.sendgrid.notify.utils.NotifyExecpion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
 public class AccessValidation implements NotifyService {

    @Autowired
    private MessageService mailSendgrid;

    @Value("${EMAILORIGIN}")
    private String email ;

    @Value("${NAMEORIGIN}")
    private String name ;

    Logger logger = LogManager.getLogger(AccessValidation.class);

    /**
     *this method allows to test the email address is valid or not
     * @param mail
     * @return
     */
    public boolean verifyParam(String mail) {
         String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(mail).matches() ;
    }

    /**
     * this method consists exclusively which work to send notifications by email to the User for
     * Activation Account
     * @param param
     * @param sendGridApiKey
     * @param url
     * @throws NotifyExecpion
     */

    @Override
    public void notifyModule( List<Object> param , String sendGridApiKey , String url , String templateId) throws NotifyExecpion {
         if (!verifyParam((String) param.get(0)))
            throw new NotifyExecpion("Paramétres non conformes");
        else {
              MailingDto mailingDto = mailingDto(param,templateId ,"url1") ;
             mailSendgrid.send(mailingDto);
             logger.info("send Email to {}", param.get(0));
        }

    }
     private MailingDto mailingDto(List<Object> param , String templateId , String url){
         DynamicTemplateData dynamicTemplateData = new DynamicTemplateData(param.get(2).toString(),"","Validation du compte",url);
         Gender gender = new Gender();
         if(!param.get(3).toString().equals("")){
             if(param.get(3).toString().equals("MALE"))
                 gender.setMale(true);
             else
                 gender.setFemme(true);
         }

         dynamicTemplateData.setGender(gender);
         List<To> tos = new ArrayList<>();
         tos.add( new To(param.get(0).toString(),param.get(1).toString()));
         List<Personalization> personalizations = new ArrayList<>() ;
         personalizations.add( new Personalization(tos,dynamicTemplateData));
         return new MailingDto(new From(email,name),personalizations , templateId) ;
     }
}
