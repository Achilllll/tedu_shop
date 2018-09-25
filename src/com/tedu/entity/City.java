package com.tedu.entity;;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Objects;
@Table("t_dict_cities")
public class City  extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5277015795040497226L;

    @Column("province_code")
    private String provinceCode;
    @Column("city_code")
    private String cityCode;
    @Column("city_name")
    private String cityName;

    public City() {
        super();
        setC(City.class);
    }

    public City(Integer id, String provinceCode, String cityCode, String cityName) {
        setC(City.class);
        setId(id);
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getId(), city.getId()) &&
                Objects.equals(getProvinceCode(), city.getProvinceCode()) &&
                Objects.equals(getCityCode(), city.getCityCode()) &&
                Objects.equals(getCityName(), city.getCityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProvinceCode(), getCityCode(), getCityName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + getId() +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }


}
