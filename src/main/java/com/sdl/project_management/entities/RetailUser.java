package com.sdl.project_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.sdl.project_management.enums.UserType;
import com.sdl.project_management.utils.PrettySerializer;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Where(clause = "del_Flag='N'")
public class RetailUser extends User implements PrettySerializer {

    private String bvn;
    private String customerId;
    private Date birthDate;
    private String resetSecurityQuestion;
    private String feedBackStatus;
    private String coverage;
    private String customizedName;


	private String tempPassword;
	private String eNairaPassword;
	@Column(name = "e_naira_user_name",length = 150)
	private String eNairaUserName;
	@Column(name = "e_naira_wallet_name",length = 100)
	private String eNairaWalletName;


    public RetailUser() {
        this.userType = (UserType.RETAIL);
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getResetSecurityQuestion() {
        return resetSecurityQuestion;
    }

    public void setResetSecurityQuestion(String resetSecurityQuestion) {
        this.resetSecurityQuestion = resetSecurityQuestion;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }


    public String getFeedBackStatus() {
        return feedBackStatus;
    }

    public void setFeedBackStatus(String feedBackStatus) {
        this.feedBackStatus = feedBackStatus;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    @Override
    @JsonIgnore
    public List<String> getDefaultSearchFields() {
        return Arrays.asList("customerId", "userName", "firstName", "lastName");
    }



    public String getCustomizedName() {
        return customizedName;
    }

    public void setCustomizedName(String customizedName) {
        this.customizedName = customizedName;
    }
    public String getENairaPassword() {
        return eNairaPassword;
    }

    public void setENairaPassword(String enairaPassword) {
        this.eNairaPassword = enairaPassword;
    }



    public void seteENairaUserName(String eNairaUsername) {
        this.eNairaUserName = eNairaUsername;
    }

    public String geteNairaUserName() {
        return eNairaUserName;
    }

    public void seteNairaUserName(String eNairaUserName) {
        this.eNairaUserName = eNairaUserName;
    }

    public String geteNairaWalletName() {
        return eNairaWalletName;
    }

    public void seteNairaWalletName(String eNairaWalletName) {
        this.eNairaWalletName = eNairaWalletName;
    }

    @Override
    @JsonIgnore
    public JsonSerializer<User> getSerializer() {
        return new JsonSerializer<>() {
            @Override
            public void serialize(User value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {

                gen.writeStartObject();
                gen.writeStringField("Username", value.userName);
                gen.writeStringField("First Name", value.firstName);
                gen.writeStringField("Last Name", value.lastName);
                gen.writeStringField("Email", value.email);
                gen.writeStringField("Phone", value.phoneNumber);
                String status = null;
                if ("A".equals(value.status))
                    status = "Active";
                else if ("I".equals(value.status))
                    status = "Inactive";
                else if ("L".equals(value.status))
                    status = "Locked";
                gen.writeStringField("Status", status);
                gen.writeStringField("Role", value.role.getName());
                gen.writeEndObject();
            }
        };
    }

    @Override
    @JsonIgnore
    public JsonSerializer<User> getAuditSerializer() {
        return new JsonSerializer<>() {
            @Override
            public void serialize(User value, JsonGenerator gen, SerializerProvider serializers)
                    throws IOException {

                gen.writeStartObject();
                if (value.id != null) {
                    gen.writeStringField("id", value.id.toString());
                } else {
                    gen.writeStringField("id", "");
                }
                gen.writeStringField("userName", value.firstName);
                gen.writeStringField("firstName", value.firstName);
                gen.writeStringField("lastName", value.lastName);
                gen.writeStringField("email", value.email);
                gen.writeStringField("phoneNumber", value.phoneNumber);
                String status = null;
                if ("A".equals(value.status))
                    status = "Active";
                else if ("I".equals(value.status))
                    status = "Inactive";
                else if ("L".equals(value.status))
                    status = "Locked";
                gen.writeStringField("status", status);
                gen.writeStringField("coverage", coverage);
                gen.writeStringField("role", value.role.getName());
                gen.writeEndObject();
            }
        };
    }

}
