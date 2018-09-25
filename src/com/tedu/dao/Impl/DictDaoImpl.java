package com.tedu.dao.Impl;

import com.tedu.dao.DictDao;
import com.tedu.entity.Area;
import com.tedu.entity.City;
import com.tedu.entity.Province;
import com.tedu.utils.ObjectMapping;
import com.tedu.utils.Operation;
import com.tedu.utils.utils.BaseEntityUtils;
import com.tedu.utils.utils.SqlUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DictDaoImpl implements DictDao {

    private Operation operation;

    public DictDaoImpl() {
        this.operation = new Operation();
    }

    @Override
    public List<Province> selectProvince() {
        Province province=new Province();
        String sql= SqlUtils.querySql(province);
        return (List<Province>) operation.query(sql, new Object[]{}, new ObjectMapping() {
            @Override
            public Object mapping(ResultSet resultSet) {
                return BaseEntityUtils.objectMapping(resultSet,province);
            }
        });
    }

    @Override
    public List<City> selectCity(String provinceCode) {
        City city=new City();
        String sql= SqlUtils.querySql(city);
        sql+=" and province_code="+provinceCode;
        return (List<City>) operation.query(sql, new Object[]{}, new ObjectMapping() {
            @Override
            public Object mapping(ResultSet resultSet) {
                return BaseEntityUtils.objectMapping(resultSet,city);
            }
        });
    }

    @Override
    public List<Area> selectArea(String cityCode) {
        Area area=new Area();
        String sql= SqlUtils.querySql(area);
        sql+=" and city_code="+cityCode;
        return (List<Area>) operation.query(sql, new Object[]{}, new ObjectMapping() {
            @Override
            public Object mapping(ResultSet resultSet) {
                return BaseEntityUtils.objectMapping(resultSet,area);
            }
        });
    }

    @Override
    public String selectProvinceNameByCode(String provinceCode) {
        String sql="select province_name from t_dict_provinces where province_code="+provinceCode;
        return (String) operation.find(sql, new Object[]{}, new ObjectMapping() {
            @Override
            public Object mapping(ResultSet resultSet) {
                Object result=null;
                try {
                    result=resultSet.getString(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    @Override
    public String selectCityNameByCode(String cityCode) {
        String sql="select city_name from t_dict_cities where city_code="+cityCode;
        return (String) operation.find(sql, new Object[]{}, new ObjectMapping() {
            @Override
            public Object mapping(ResultSet resultSet) {
                Object result=null;
                try {
                    result=resultSet.getString(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result;
            }
        });
    }

    @Override
    public String selectAreaNameByCode(String areaCode) {
        String sql="select area_name from t_dict_provinces where area_code="+areaCode;
        return (String) operation.find(sql, new Object[]{}, new ObjectMapping() {
            @Override
            public Object mapping(ResultSet resultSet) {
                Object result=null;
                try {
                    result=resultSet.getString(1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result;
            }
        });
    }
}
