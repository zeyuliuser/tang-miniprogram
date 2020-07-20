package com.tang.tangminiprogram.Utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtils<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long totalCount;

    private long pageSize;

    private long totalPage;

    private long currPage;

    private List<E> list;
    public PageUtils() {
    }

    public PageUtils(List<E> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = (long)totalCount;
        this.pageSize = (long)pageSize;
        this.currPage = (long)currPage;
        this.totalPage = (long)((int)Math.ceil((double)totalCount / (double)pageSize));
    }

    public PageUtils(List<E> list, long totalCount, long pageSize, long currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (long)((int)Math.ceil((double)totalCount / (double)pageSize));
    }

    public PageUtils(IPage<E> page) {
        this.list = page.getRecords();
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = page.getPages();
    }

    public static Map<String, Object> getPageMap(PageUtils<?> objPage) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("list", objPage.getList());
        resultMap.put("totalCount", objPage.getTotalCount());
        resultMap.put("totalPage", objPage.getTotalCount());
        resultMap.put("currPage", objPage.getCurrPage());
        resultMap.put("pageSize", objPage.getPageSize());
        return resultMap;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = (long)totalCount;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = (long)pageSize;
    }

    public long getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = (long)totalPage;
    }

    public long getCurrPage() {
        return this.currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = (long)currPage;
    }

    public List<E> getList() {
        return this.list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
