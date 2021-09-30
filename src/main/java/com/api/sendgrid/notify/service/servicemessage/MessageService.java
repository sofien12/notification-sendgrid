package com.api.sendgrid.notify.service.servicemessage;

/**
 *
 * this interface consists send Message with canel using
 * @author Sofien Trabelsi
 */

import com.api.sendgrid.notify.entity.dto.MailingDto;


public interface MessageService {

    void send(MailingDto mailingDto) ;

}
