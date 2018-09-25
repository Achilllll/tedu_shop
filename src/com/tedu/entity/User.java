package com.tedu.entity;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * 实体类
 * @author Wanghuidi
 */
@Table("t_user")
public class User  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3627926787124385443L;

    @Column("username")
    private String username;
    @Column("password")
    private String password;
    @Column("phone")
    private String phone;
    @Column("email")
    private String email;
    @Column("image")
    private String image;
    @Column("gender")
    private Integer gender;
    @Column("created_user")
    private String createdUser;
    @Column("created_time")
    private Date createdTime;
    @Column("modified_user")
    private String modifiedUser;
    @Column("modified_time")
    private Date modifiedTime;

    public User() {
        super();
        setC(User.class);
    }

    public User(Integer id, String username, String password, String phone, String email, String image, Integer gender, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        super();
        setC(User.class);
        setId(id);
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.gender = gender;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getImage(), user.getImage()) &&
                Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getCreatedUser(), user.getCreatedUser()) &&
                Objects.equals(getCreatedTime(), user.getCreatedTime()) &&
                Objects.equals(getModifiedUser(), user.getModifiedUser()) &&
                Objects.equals(getModifiedTime(), user.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getPhone(), getEmail(), getImage(), getGender(), getCreatedUser(), getCreatedTime(), getModifiedUser(), getModifiedTime());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", gender=" + gender +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


}
