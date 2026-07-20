package com.techlab.filter;

public class FilterBase {
    private String searchText;
    private Integer page;
    private Integer size;

    
    public FilterBase(String searchText, Integer page, Integer size) {
        this.searchText = searchText;
        this.page = page;
        this.size = size;
    }


    public String getSearchText() {
        return searchText;
    }


    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }


    public Integer getPage() {
        return page;
    }


    public void setPage(Integer page) {
        this.page = page;
    }


    public Integer getSize() {
        return size;
    }


    public void setSize(Integer size) {
        this.size = size;
    }
    
}
