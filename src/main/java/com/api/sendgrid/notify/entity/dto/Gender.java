package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Gender {

    private boolean male = false ;
    private boolean femme = false ;


    public void setMale(boolean male) {
        this.male = male;
    }

    public void setFemme(boolean femme) {
        this.femme = femme;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isFemme() {
        return femme;
    }
}
