package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;


import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class MailingDto {

    @JsonProperty("from")
    private From from;
    @JsonProperty("personalizations")
    private List<Personalization> personalizations;

    @JsonProperty("template_id")
    private String templateId;

    public MailingDto() {
    }

    public MailingDto(From from, List<Personalization> personalizations, String templateId) {
        this.from = from;
        this.personalizations = personalizations;
        this.templateId = templateId;
    }

    @JsonProperty("from")
    public void setFrom(From from) {
        this.from = from;
    }

    @JsonProperty("personalizations")
    public void setPersonalizations(List<Personalization> personalizations) {
        this.personalizations = personalizations;
    }

    @JsonProperty("template_id")
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @JsonProperty("from")
    public From getFrom() {
        return from;
    }

    @JsonProperty("personalizations")
    public List<Personalization> getPersonalizations() {
        return personalizations;
    }

    @JsonProperty("template_id")
    public String getTemplateId() {
        return templateId;
    }
}
