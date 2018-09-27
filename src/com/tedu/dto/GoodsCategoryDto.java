package com.tedu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodsCategoryDto {
    private String mainCategoryName;
    private List<Map<String, List<CategoryDto>>> categories;

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public List<Map<String, List<CategoryDto>>> getCategories() {
        return categories;
    }

    public void setCategories(List<Map<String, List<CategoryDto>>> categories) {
        this.categories = categories;
    }

    public GoodsCategoryDto(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
        categories =new ArrayList<>();
    }
}
