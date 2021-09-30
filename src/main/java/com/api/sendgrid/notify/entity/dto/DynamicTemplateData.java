package com.api.sendgrid.notify.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class DynamicTemplateData {

    private String firstName;
    private Gender gender;
    private Gender genderSender;
    private String lastName;
    private String schoolName;
    private String directorFirstName;
    private String directorLastName;
    private String comment;
    private String subject;
    private String link;
    private String status;
    private String statusInfo;
    private String title;
    private String professorFirstName;
    private String professorLastName;
    private String courseName;
    private String studentFirstName;
    private String studentLastName;
    private List<Cours> cours;

    public DynamicTemplateData() {
    }

    public DynamicTemplateData(String firstName, String schoolName, String subject, String link) {
        this.firstName = firstName;
        this.schoolName = schoolName;
        this.subject = subject;
        this.link = link;
    }

    public DynamicTemplateData(String firstName,  String subject, String link) {
        this.firstName = firstName;
        this.subject = subject;
        this.link = link;
    }

    public DynamicTemplateData(String firstName, String schoolName, String directorFirstName, String directorLastName, String comment, String subject) {
        this.firstName = firstName;

        this.schoolName = schoolName;
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.comment = comment;
        this.subject = subject;
    }

    public DynamicTemplateData(String firstName,  String schoolName, String directorFirstName, String directorLastName, String comment, String subject, String link) {
        this.firstName = firstName;
        this.schoolName = schoolName;
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.comment = comment;
        this.subject = subject;
        this.link = link;
    }

    public DynamicTemplateData(String firstName, String schoolName, String subject, String status, String title) {
        this.firstName = firstName;
        this.schoolName = schoolName;
        this.subject = subject;
        this.status = status;
        this.title = title;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGenderSender(Gender genderSender) {
        this.genderSender = genderSender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setDirectorFirstName(String directorFirstName) {
        this.directorFirstName = directorFirstName;
    }

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setProfessorFirstName(String professorFirstName) {
        this.professorFirstName = professorFirstName;
    }

    public void setProfessorLastName(String professorLastName) {
        this.professorLastName = professorLastName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public Gender getGender() {
        return gender;
    }

    public Gender getGenderSender() {
        return genderSender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getDirectorFirstName() {
        return directorFirstName;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }


    public String getComment() {
        return comment;
    }

    public String getSubject() {
        return subject;
    }

    public String getLink() {
        return link;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }


    public String getTitle() {
        return title;
    }

    public String getProfessorFirstName() {
        return professorFirstName;
    }

    public String getProfessorLastName() {
        return professorLastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public List<Cours> getCours() {
        return cours;
    }


}
