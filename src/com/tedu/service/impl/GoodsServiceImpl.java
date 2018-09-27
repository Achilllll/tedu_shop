package com.tedu.service.impl;

import com.tedu.dao.GoodsCategoryDao;
import com.tedu.dao.GoodsDao;
import com.tedu.dao.Impl.GoodsDaoImpl;
import com.tedu.dao.Impl.GoodsGategoryDaoImpl;
import com.tedu.dto.CategoryDto;
import com.tedu.dto.GoodsCategoryDto;
import com.tedu.dto.GoodsDto;
import com.tedu.entity.Goods;
import com.tedu.entity.GoodsCategory;
import com.tedu.service.GoodsService;

import java.util.*;

public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao;
    private GoodsCategoryDao goodsCategoryDao;
    public static final int  FIRST_LEVEL=3;
    public static final int SECOND_LEVEL=5;

    public GoodsServiceImpl() {
        goodsCategoryDao=new GoodsGategoryDaoImpl();
        goodsDao=new GoodsDaoImpl();
    }

    @Override
    public List<GoodsDto> listGoods(Integer categoryId, Integer offset, Integer count) {
        List<Goods> goodsList=goodsDao.selectGoodsByCategoryId(categoryId,offset,count);
        List<GoodsDto> resultList=new ArrayList<>();
        if(Objects.nonNull(goodsList)&&goodsList.size()>0){
            for (Goods good:goodsList) {
                resultList.add(new GoodsDto(good.getTitle(),good.getPrice(),good.getImage(),good.getId()));
            }
        }
        return resultList;
    }

    @Override
    public GoodsCategoryDto getCategories(Integer mainCategoryId, Integer offset) {
        //先根据主id查出主类
        GoodsCategoryDto result=null;
        GoodsCategory mainCategory=goodsCategoryDao.selectCategoryById(mainCategoryId);
        if(Objects.nonNull(mainCategory)){
            //查询主层目录，确保其存在
            result=new GoodsCategoryDto(mainCategory.getName());
            //这里的offset
            List<GoodsCategory> firstLevel=goodsCategoryDao.selectCategoryByParentId(mainCategoryId,offset,FIRST_LEVEL);
            //在第一级目录存在的情况下遍历第一级目录
            for (int i = 0; Objects.nonNull(firstLevel)&&i <firstLevel.size() ; i++) {
                //得到第一级目录中的其中一个对象
                GoodsCategory currentCategory1=firstLevel.get(i);
                List<Map<String, List<CategoryDto>>> levels=result.getCategories();
                //装配第一层目录项目的内容
                Map<String, List<CategoryDto>> firstLevelContent=new HashMap<>();
                //加载对应的第二层目录
                List<GoodsCategory> secondLevel=goodsCategoryDao.selectCategoryByParentId(currentCategory1.getId(),1,SECOND_LEVEL);
                List<CategoryDto> secondLevelContent=new ArrayList<>();
                //装配第二层目录项目的内容，即第二级目录的类别名称
                for (int j = 0; Objects.nonNull(secondLevel)&&j <secondLevel.size() ; j++) {
                    secondLevelContent.add(new CategoryDto(secondLevel.get(i).getId(),secondLevel.get(j).getName()));
                }
                //将第一级目录名和其对应的第二级目录形成一个映射并保存在链表中，例如第一级目录名电脑外设，第二级目录名电脑外设1，电脑外设2等等
                firstLevelContent.put(currentCategory1.getName(),secondLevelContent);
                levels.add(firstLevelContent);
            }

        }
        return result;
    }

    @Override
    public Goods goodsDetail(Integer id) {
        return goodsDao.selectGoodsById(id);
    }
}
