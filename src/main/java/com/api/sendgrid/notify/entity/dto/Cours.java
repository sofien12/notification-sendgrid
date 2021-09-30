package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Cours {
    private String name ;

    public Cours() {
    }

    public Cours(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
