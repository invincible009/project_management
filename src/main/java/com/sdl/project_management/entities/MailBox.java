package com.sdl.project_management.entities;

import com.sdl.project_management.enums.UserType;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wunmi on 27/03/2017.
 */


@Entity
@Where(clause ="del_Flag='N'" )
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"userId", "userType"}))
public class MailBox extends AbstractEntity{
    private Long userId;
    private UserType userType;


    public  MailBox(){}

    public  MailBox(Long userId, UserType userType){
    	this.userId=userId;
    	this.userType=userType;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
