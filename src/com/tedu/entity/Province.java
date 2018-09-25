package com.tedu.entity;

import com.tedu.entity.model.BaseEntity;
import com.tedu.utils.annotation.Column;
import com.tedu.utils.annotation.Table;

import java.io.Serializable;
import java.util.Objects;

@Table("t_dict_provinces")
public class Province extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1743509421168233065L;

    @Column("province_code")
    private String provinceCode;
    @Column("province_name")
    private String provinceName;

    public Province() {
        super();
        setC(Province.class);
    }

    public Province(Integer id, String provinceCode, String provinceName) {
        setC(Province.class);
        setId(id);
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Province)) return false;
        Province province = (Province) o;
        return Objects.equals(getId(), province.getId()) &&
                Objects.equals(getProvinceCode(), province.getProvinceCode()) &&
                Objects.equals(getProvinceName(), province.getProvinceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProvinceCode(), getProvinceName());
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + getId() +
                ", provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }

}
