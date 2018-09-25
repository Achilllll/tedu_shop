package com.tedu.entity;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table("t_address")
public class Address extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 2440169729997559533L;

    @Column("uid")
    private Integer uid;
    @Column("recv_name")
    private String recvUsername;
    @Column("recv_province")
    private String recvProvinceCode;
    @Column("recv_city")
    private String recvCityCode;
    @Column("recv_area")
    private String recvAreaCode;
    @Column("recv_addr")
    private String recvAddress;
    @Column("recv_district")
    private String recvDistrict;
    @Column("recv_phone")
    private String recvPhone;
    @Column("recv_tel")
    private String recvTel;
    @Column("recv_zip")
    private String recvZip;
    @Column("recv_tag")
    private String recvTag;
    @Column("is_default")
    private Integer isDefault;
    @Column("created_user")
    private String createdUser;
    @Column("created_time")
    private Date createdTime;
    @Column("modified_user")
    private String modifiedUser;
    @Column("modified_time")
    private Date modifiedTime;

    public Address() {
        super();
        this.setC(Address.class);
    }

    public Address(Integer id, Integer uid, String recvUsername, String recvProvinceCode, String recvCityCode, String recvAreaCode, String recvAddress, String recvDistrict, String recvPhone, String recvTel, String recvZip, String recvTag, Integer isDefault, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        this.setC(Address.class);
        setId(id);
        this.uid = uid;
        this.recvUsername = recvUsername;
        this.recvProvinceCode = recvProvinceCode;
        this.recvCityCode = recvCityCode;
        this.recvAreaCode = recvAreaCode;
        this.recvAddress = recvAddress;
        this.recvDistrict = recvDistrict;
        this.recvPhone = recvPhone;
        this.recvTel = recvTel;
        this.recvZip = recvZip;
        this.recvTag = recvTag;
        this.isDefault = isDefault;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + this.getId() +
                ", uid=" + uid +
                ", recvUsername='" + recvUsername + '\'' +
                ", recvProvinceCode='" + recvProvinceCode + '\'' +
                ", recvCityCode='" + recvCityCode + '\'' +
                ", recvAreaCode='" + recvAreaCode + '\'' +
                ", recvAddress='" + recvAddress + '\'' +
                ", recvDistrict='" + recvDistrict + '\'' +
                ", recvPhone='" + recvPhone + '\'' +
                ", recvTel='" + recvTel + '\'' +
                ", recvZip='" + recvZip + '\'' +
                ", recvTag='" + recvTag + '\'' +
                ", isDefault=" + isDefault +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId()) &&
                Objects.equals(getUid(), address.getUid()) &&
                Objects.equals(getRecvUsername(), address.getRecvUsername()) &&
                Objects.equals(getRecvProvinceCode(), address.getRecvProvinceCode()) &&
                Objects.equals(getRecvCityCode(), address.getRecvCityCode()) &&
                Objects.equals(getRecvAreaCode(), address.getRecvAreaCode()) &&
                Objects.equals(getRecvAddress(), address.getRecvAddress()) &&
                Objects.equals(getRecvDistrict(), address.getRecvDistrict()) &&
                Objects.equals(getRecvPhone(), address.getRecvPhone()) &&
                Objects.equals(getRecvTel(), address.getRecvTel()) &&
                Objects.equals(getRecvZip(), address.getRecvZip()) &&
                Objects.equals(getRecvTag(), address.getRecvTag()) &&
                Objects.equals(getIsDefault(), address.getIsDefault()) &&
                Objects.equals(getCreatedUser(), address.getCreatedUser()) &&
                Objects.equals(getCreatedTime(), address.getCreatedTime()) &&
                Objects.equals(getModifiedUser(), address.getModifiedUser()) &&
                Objects.equals(getModifiedTime(), address.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUid(), getRecvUsername(), getRecvProvinceCode(), getRecvCityCode(), getRecvAreaCode(), getRecvAddress(), getRecvDistrict(), getRecvPhone(), getRecvTel(), getRecvZip(), getRecvTag(), getIsDefault(), getCreatedUser(), getCreatedTime(), getModifiedUser(), getModifiedTime());
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRecvUsername() {
        return recvUsername;
    }

    public void setRecvUsername(String recvUsername) {
        this.recvUsername = recvUsername;
    }

    public String getRecvProvinceCode() {
        return recvProvinceCode;
    }

    public void setRecvProvinceCode(String recvProvinceCode) {
        this.recvProvinceCode = recvProvinceCode;
    }

    public String getRecvCityCode() {
        return recvCityCode;
    }

    public void setRecvCityCode(String recvCityCode) {
        this.recvCityCode = recvCityCode;
    }

    public String getRecvAreaCode() {
        return recvAreaCode;
    }

    public void setRecvAreaCode(String recvAreaCode) {
        this.recvAreaCode = recvAreaCode;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public String getRecvDistrict() {
        return recvDistrict;
    }

    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvTel() {
        return recvTel;
    }

    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel;
    }

    public String getRecvZip() {
        return recvZip;
    }

    public void setRecvZip(String recvZip) {
        this.recvZip = recvZip;
    }

    public String getRecvTag() {
        return recvTag;
    }

    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
