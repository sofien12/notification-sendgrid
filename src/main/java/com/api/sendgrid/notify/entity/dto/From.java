package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class From {
    private String email ;
    private String name ;


    public From() {
    }

    public From(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public From(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
