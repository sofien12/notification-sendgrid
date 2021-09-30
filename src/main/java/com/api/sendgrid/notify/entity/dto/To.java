package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sendgrid.Email;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class To {
    private String email ;
    private String name ;


    public To() {
    }

    public To(String email) {
        this.email = email;
    }

    public To(String email, String name) {
        this.email = email;
        this.name = name;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
