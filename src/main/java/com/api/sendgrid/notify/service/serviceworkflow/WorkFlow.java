package com.api.sendgrid.notify.service.serviceworkflow;

import com.api.sendgrid.notify.utils.NotifyExecpion;

import java.util.List;

public interface WorkFlow {

    void notifyCode(String event , List<Object> param) throws NotifyExecpion;
}
