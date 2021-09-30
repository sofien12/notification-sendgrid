package com.api.sendgrid.notify.service.serviceworkflow;

/**
 * cette class permet de retourner si le Event existe dans la base de donner ou nn
 *
 * @Author sofien trabelsi
 */

import com.api.sendgrid.notify.service.servicenotify.NotifyService;
import com.api.sendgrid.notify.utils.Events;
import com.api.sendgrid.notify.utils.NotifyExecpion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkFlowImpl implements WorkFlow {

    @Autowired
    private NotifyService checkMail;


    @Autowired
    private NotifyService checkPassword;

    @Autowired
    private NotifyService accessValidation ;

    @Autowired
    private NotifyService changePassword;


    @Value("${SENDGRID_API_KEY}")
    private String sendgrid;

    @Value("${url}")
    private String url;

    @Value("${dns}")
    private String dns;

    // Template_id Sendgrid

    @Value("${ACCOUNT_CHECK_MAIL}")
    private String checkMailTempaletId;

    @Value("${PASSWORD_RESET}")
    private String passwordRestTemplateId;

    @Value("${ACCOUNT_VALID}")
    private String acountValidTemplateId ;

    @Value("${PASSWORD_CHANGE_OK}")
    private String passwordChangeTemplateId ;

    /**
     * @param event
     * @param param
     * @throws NotifyExecpion
     */
    @Override
    public void notifyCode(String event, List<Object> param) throws NotifyExecpion {


        switch (event) {
            case Events.ACCOUNT_CHECK_MAIL:
                checkMail.notifyModule(param, sendgrid, null, checkMailTempaletId);
                break;
            case Events.PASSWORD_CHANGE_OK:

            case Events.PASSWORD_CHECK  :
                changePassword.notifyModule(param, sendgrid, null, passwordChangeTemplateId);
                break;
            case Events.ACCOUNT_DELETE  :
                accessValidation.notifyModule(param, sendgrid, null, acountValidTemplateId);
                break;

            default:
                throw new NotifyExecpion("Error with Events not exist");

        }

    }
}
