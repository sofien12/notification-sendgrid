package com.api.sendgrid.notify.service.servicemessage;
/**
 *
 * this class implements MessageService for  send Message with canel using
 * @author Sofien Trabelsi
 */

import com.api.sendgrid.notify.entity.dto.MailingDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import org.springframework.stereotype.Service;


@Service
 public class MailService implements MessageService {
    Logger logger = LogManager.getLogger(MailService.class);

    @Value("${SENDGRID_API_KEY}")
    private String sendgridApiKey;

    @Value("${URL_SENDGRID}")
    private String urlSendgrid ;

    @Autowired
    private RestTemplate restTemplate;




    @Override
    public void send(MailingDto mailingDto)  {
       HttpHeaders headers = new HttpHeaders() ;
        headers.setBearerAuth(sendgridApiKey);
        HttpEntity request = new HttpEntity<>(mailingDto,headers);
        restTemplate.exchange(urlSendgrid , HttpMethod.POST, request, Void.class);
    }
}
