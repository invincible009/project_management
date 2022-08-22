package com.sdl.project_management.entities;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;


@Entity
@Where(clause ="del_Flag='N'")
public class Notifications extends AbstractEntity {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notifications{" +
                "message='" + message + '\'' +
                '}';
    }
}
