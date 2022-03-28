package com.edward.mt.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class User {
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private int id;
    @NotBlank(message = "用户名不能为空！")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String userName;
    @NotBlank(message = "密码不能为空！")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String passWord;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String nickName;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String avatar;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Date created;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Date updated;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private int status;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String email;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", status=" + status +
                ", email='" + email + '\'' +
                '}';
    }
}
