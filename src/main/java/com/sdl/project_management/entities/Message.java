package com.sdl.project_management.entities;


import com.sdl.project_management.enums.UserType;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
@Where(clause ="del_Flag='N'" )
public class Message extends AbstractEntity{


    private String sender;
    private String recipient;
    private UserType recipientType;
    private String subject;


    private String body;
    private Date dateCreated;
    private String status;
    @ManyToOne
    private MailBox mailBox;
    private String tag;



    public Message() {
    }



    public Message(String sender, String recipient, String subject, String body, Date dateCreated, String status) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public UserType getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(UserType recipientType) {
        this.recipientType = recipientType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public MailBox getMailBox() {
        return mailBox;
    }

    public void setMailBox(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", recipientType=" + recipientType +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", mailBox=" + mailBox +
                ", tag='" + tag + '\'' +
                '}';
    }
}

