package com.sdl.project_management.entities;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Where(clause ="del_Flag='N'" )
public class UserGroup extends AbstractEntity {

    private String name;
    private String description;
    private Date dateCreated;

    public UserGroup() {
    }

    public UserGroup(String name, String description, Date dateCreated) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public String toString() {
        return "UserGroup{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
