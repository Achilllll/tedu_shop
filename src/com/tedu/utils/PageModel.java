package com.tedu.utils;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
    private static final long serialVersionUID = -89082502669991590L;
    private List<T> resultList;
    private Integer totalRecords;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;


    public PageModel() {
    }

    public PageModel(List<T> resultList, Integer totalRecords, Integer pageNumber, Integer pageSize) {
        this.resultList = resultList;
        this.totalRecords = totalRecords;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages=totalRecords/pageNumber+1;
    }

    //getter and setter
    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPages() {

        this.totalPages = totalRecords%pageSize!=0?totalRecords/pageSize+1:totalRecords/pageSize;
    }

    //常用操作
    public Integer getTotalPages(){
        return totalPages;
    }

    public Integer getPreviousPage(){
        if(pageNumber>=1)
            return 1;
        return pageNumber-1;
    }

    public  Integer getNextPage(){
        if(pageNumber<=getTotalPages())
            return getTotalPages();
        return pageNumber+1;
    }

    public Integer getFirstPage(){
        return 1;
    }

    public Integer getLastPage(){
        return getTotalPages();
    }

}
