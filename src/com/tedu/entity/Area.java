package com.tedu.entity;;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Objects;

@Table("t_dict_areas")
public class Area extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8719339816778424301L;

    @Column("city_code")
    private String cityCode;
    @Column("area_code")
    private String areaCode;
    @Column("area_name")
    private String areaName;

    public Area() {
        super();
        setC(Area.class);
    }

    public Area(Integer id, String cityCode, String areaCode, String areaName) {
        setC(Area.class);
        setId(id);
        this.cityCode = cityCode;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }


    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return Objects.equals(getId(), area.getId()) &&
                Objects.equals(getCityCode(), area.getCityCode()) &&
                Objects.equals(getAreaCode(), area.getAreaCode()) &&
                Objects.equals(getAreaName(), area.getAreaName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCityCode(), getAreaCode(), getAreaName());
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + getId() +
                ", cityCode='" + cityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }


}
