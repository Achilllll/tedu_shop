package com.tedu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsCategoryDto {
    private String mainCategoryName;
    private List<Map<String, List<String>>> catgories;

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public List<Map<String, List<String>>> getCatgories() {
        return catgories;
    }

    public void setCatgories(List<Map<String, List<String>>> catgories) {
        this.catgories = catgories;
    }

    public GoodsCategoryDto(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
        catgories=new ArrayList<>();
    }
}
