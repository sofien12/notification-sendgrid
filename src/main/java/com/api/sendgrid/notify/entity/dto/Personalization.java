package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString

public class Personalization {

    @JsonProperty("to")
    private List<To> to;

    @JsonProperty("dynamic_template_data")
    private DynamicTemplateData dynamicTemplateData;

    public Personalization() {
    }

    public Personalization(List<To> to, DynamicTemplateData dynamicTemplateData) {
        this.to = to;
        this.dynamicTemplateData = dynamicTemplateData;
    }
    @JsonProperty("to")
    public void setTo(List<To> to) {
        this.to = to;
    }

    @JsonProperty("dynamic_template_data")
    public void setDynamicTemplateData(DynamicTemplateData dynamicTemplateData) {
        this.dynamicTemplateData = dynamicTemplateData;
    }

    @JsonProperty("to")
    public List<To> getTo() {
        return to;
    }



    @JsonProperty("dynamic_template_data")
    public DynamicTemplateData getDynamicTemplateData() {
        return dynamicTemplateData;
    }
}
