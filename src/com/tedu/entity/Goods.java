package com.tedu.entity;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Column("t_goods")
public class Goods extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8747034229062577681L;
    @Column("category_id")
    private Integer categoryId; // 分类id
    @Column("item_type")
    private String itemType; // 商品型号
    @Column("title")
    private String title; // 商品的名称
    @Column("sell_point")
    private String sellPoint; // 卖点
    @Column("price")
    private Double price; // 价格
    @Column("num")
    private Integer num; // 库存
    @Column("barcode")
    private String barcode; // 条形码
    @Column("image")
    private String image; // 图片路径
    @Column("status")
    private Integer status; // 商品状态
    @Column("priority")
    private Integer priority; // 优先级
    @Column("created_user")
    private String createdUser;
    @Column("created_time")
    private Date createdTime;
    @Column("modified_user")
    private String modifiedUser;
    @Column("modified_time")
    private Date modifiedTime;

    public Goods() {
        super();
        setC(Goods.class);
    }

    public Goods(Integer id, Integer categoryId, String itemType, String title, String sellPoint, Double price, Integer num, String barcode, String image, Integer status, Integer priority, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        setC(Goods.class);
        setId(id);
        this.categoryId = categoryId;
        this.itemType = itemType;
        this.title = title;
        this.sellPoint = sellPoint;
        this.price = price;
        this.num = num;
        this.barcode = barcode;
        this.image = image;
        this.status = status;
        this.priority = priority;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(getId(), goods.getId()) &&
                Objects.equals(getCategoryId(), goods.getCategoryId()) &&
                Objects.equals(getItemType(), goods.getItemType()) &&
                Objects.equals(getTitle(), goods.getTitle()) &&
                Objects.equals(getSellPoint(), goods.getSellPoint()) &&
                Objects.equals(getPrice(), goods.getPrice()) &&
                Objects.equals(getNum(), goods.getNum()) &&
                Objects.equals(getBarcode(), goods.getBarcode()) &&
                Objects.equals(getImage(), goods.getImage()) &&
                Objects.equals(getStatus(), goods.getStatus()) &&
                Objects.equals(getPriority(), goods.getPriority()) &&
                Objects.equals(getCreatedUser(), goods.getCreatedUser()) &&
                Objects.equals(getCreatedTime(), goods.getCreatedTime()) &&
                Objects.equals(getModifiedUser(), goods.getModifiedUser()) &&
                Objects.equals(getModifiedTime(), goods.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategoryId(), getItemType(), getTitle(), getSellPoint(), getPrice(), getNum(), getBarcode(), getImage(), getStatus(), getPriority(), getCreatedUser(), getCreatedTime(), getModifiedUser(), getModifiedTime());
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + getId() + '\'' +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
