package com.api.sendgrid.notify.service.servicenotify;

import com.api.sendgrid.notify.utils.NotifyExecpion;

import java.util.List;


public interface NotifyService {

    void notifyModule( List<Object> param, String sendGridApiKey , String url , String templateId) throws NotifyExecpion;
}
