package com.api.sendgrid.notify.utils;

/**
 *  Class NotifyExecpion to generate exxception if there is Exception
 *
 * @author Sofien Trabelsi
 */

public class NotifyExecpion extends Exception {

    public NotifyExecpion(String message) {
        super(message);
    }
}
