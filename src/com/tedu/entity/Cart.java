package com.tedu.entity;;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table("t_cart")
public class Cart extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 812218087679890106L;
    @Column("userid")
    private Integer uid;
    @Column("goodsid")
    private String goodsId;
    @Column("count")
    private Integer count;

    public Cart() {
        super();
        setC(Cart.class);
    }

    public Cart(Integer id, Integer uid, String goodsId, Integer num, String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        setC(Cart.class);
        setId(id);
        this.uid = uid;
        this.goodsId = goodsId;
        this.count = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(getId(), cart.getId()) &&
                Objects.equals(getUid(), cart.getUid()) &&
                Objects.equals(getGoodsId(), cart.getGoodsId()) &&
                Objects.equals(getCount(), cart.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUid(), getGoodsId(), getCount());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + getId() +
                ", uid=" + uid +
                ", goodsId='" + goodsId + '\'' +
                ", count=" + count +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
