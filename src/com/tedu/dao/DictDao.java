package com.tedu.dao;

import com.tedu.entity.Area;
import com.tedu.entity.City;
import com.tedu.entity.Province;

import java.util.List;

public interface DictDao {

    /**
     * 查询省份信息
     * @return
     */
    List<Province> selectProvince();

    /**
     * 查询城市信息
     * @param provinceCode
     * @return
     */
    List<City> selectCity(String provinceCode);

    /**
     * 查询区域信息
     * @param cityCode
     * @return
     */
    List<Area> selectArea(String cityCode);

    /**
     * 查询省名称
     * @param provinceCode
     * @return
     */
    String selectProvinceNameByCode(String provinceCode);

    /**
     * 查询城市名称
     * @param cityCode
     * @return
     */
    String selectCityNameByCode(String cityCode);

    /**
     * 查询区域名称
     * @param areaCode
     * @return
     */
    String selectAreaNameByCode(String areaCode);



}
