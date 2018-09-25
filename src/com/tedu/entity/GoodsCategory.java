package com.tedu.entity;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table("t_goods_category")
public class GoodsCategory  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4112281369212857631L;

    @Column("parent_id")
    private Integer parentId; // 父分类，如果是0表示一级分类
    @Column("name")
    private String name; // 分类名称
    @Column("status")
    private Integer status; // 分类状态，1表示正常，2表示删除
    @Column("sort_order")
    private Integer sortOrder; // 排序号
    @Column("is_parent")
    private Integer isParent; // 是否是父分类
    @Column("created_user")
    private String createdUser;
    @Column("created_time")
    private Date createdTime;
    @Column("modified_user")
    private String modifiedUser;
    @Column("modified_time")
    private Date modifiedTime;

    public GoodsCategory() {
        super();
        setC(GoodsCategory.class);
    }

    public GoodsCategory(Integer id, Integer parentId, String name, Integer status, Integer sortOrder, Integer isParent, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        setC(GoodsCategory.class);
        setId(id);
        this.parentId = parentId;
        this.name = name;
        this.status = status;
        this.sortOrder = sortOrder;
        this.isParent = isParent;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsCategory)) return false;
        GoodsCategory that = (GoodsCategory) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getParentId(), that.getParentId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getSortOrder(), that.getSortOrder()) &&
                Objects.equals(getIsParent(), that.getIsParent()) &&
                Objects.equals(getCreatedUser(), that.getCreatedUser()) &&
                Objects.equals(getCreatedTime(), that.getCreatedTime()) &&
                Objects.equals(getModifiedUser(), that.getModifiedUser()) &&
                Objects.equals(getModifiedTime(), that.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getParentId(), getName(), getStatus(), getSortOrder(), getIsParent(), getCreatedUser(), getCreatedTime(), getModifiedUser(), getModifiedTime());
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "id=" + getId() +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", isParent='" + isParent + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
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
