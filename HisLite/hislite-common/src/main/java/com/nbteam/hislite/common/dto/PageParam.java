package com.nbteam.hislite.common.dto;

import java.io.Serializable;

/**
 * 分页参数传递工具类 .
 * 
 */
public class PageParam implements Serializable {

    public static final String SORT_DESC = "DESC";
    public static final String SORT_ASC = "ASC";

    private static final long serialVersionUID = 6297178964005032338L;
    private int pageNum = 1; // 当前页数
    private int numPerPage = 10; // 每页记录数
    private String orderBy;
    private String sort = SORT_DESC;

    /** {@linkplain #orderBy} */
    public String getOrderBy() {
        return orderBy;
    }

    /** {@linkplain #orderBy} */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /** {@linkplain #sort} */
    public String getSort() {
        return sort;
    }

    /** {@linkplain #sort} */
    public void setSort(String sort) {
        this.sort = sort;
    }

    public PageParam() {
    }

    public PageParam(int pageNum, int numPerPage) {
        this.pageNum = pageNum;
        this.numPerPage = numPerPage;
    }

    /** 当前页数 */
    public int getPageNum() {
        return pageNum;
    }

    /** 当前页数 */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /** 每页记录数 */
    public int getNumPerPage() {
        return numPerPage;
    }

    /** 每页记录数 */
    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    /**
     * 分页的起始位置
     * 
     * @author liuzhongqi
     * @date: 2016年9月26日 下午4:28:34
     * @version 1.0
     *
     * @return
     */
    public int getStartIndex() {
        return (pageNum - 1) * numPerPage;
    }
}