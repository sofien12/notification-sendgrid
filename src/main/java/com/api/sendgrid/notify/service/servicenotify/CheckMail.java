package com.api.sendgrid.notify.service.servicenotify;

import com.api.sendgrid.notify.entity.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.api.sendgrid.notify.service.servicemessage.MessageService;
import com.api.sendgrid.notify.utils.NotifyExecpion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * this class consists exclusively of void and boolean methods
 * which work to send notifications by email to the user
 * check Mail
 * @author Sofien Trabelsi
 * @version 1.0
 */
@Service
public class CheckMail implements NotifyService {


    Logger logger = LogManager.getLogger(CheckMail.class);

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
     *this method allows to test the email address and token is valid or not
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
     * which work to send notifications by email to the user
     * check Mail
     * parameter 0 : Receiver's e-mail
     * parameter 1 : FirstName
     * parameter 2 : gender
     * paramater 3 : token
     * paramater 4 : domaine
     * paramater 5 : nameSchool
     * @param param
     * @param sendGridApiKey
     * @param urlNull
     * @throws NotifyExecpion
     */
    @Override
    public void notifyModule( List<Object> param , String sendGridApiKey ,String urlNull , String templateId) throws NotifyExecpion {

        if (!verifyParam((String) param.get(0), (String) param.get(3)))
            throw new NotifyExecpion("Paramétres non conformes");
        else {

            String url1 = ! (environment.getActiveProfiles()[0].equals("local"))?" https://"+ param.get(4)+"/auth/validateMail/token/" + param.get(3): url+"auth/validateMail/token/" + param.get(3);
            MailingDto mailingDto = mailingDto(param,templateId ,url1) ;
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
        DynamicTemplateData dynamicTemplateData = new DynamicTemplateData((String)param.get(1),(String)param.get(5),"Bienvenue sur Koors",url);
        Gender gender = new Gender();
        if(!param.get(2).toString().equals("")){
            if(param.get(2).toString().equals("MALE"))
                gender.setMale(true);
            else
                gender.setFemme(true);
        }

        dynamicTemplateData.setGender(gender);
        List<To> tos = new ArrayList<>();
        tos.add( new To((String)param.get(0),(String)param.get(1)));
        List<Personalization> personalizations = new ArrayList<>() ;
        personalizations.add( new Personalization(tos,dynamicTemplateData));
        return new MailingDto(new From(emailKoors,nameKoors),personalizations , templateId) ;
    }


}
