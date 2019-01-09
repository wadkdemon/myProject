package cn.com.guimei.pojo;

import java.util.List;

public class Page<T> {
    private int pageSize;
    private int currentPage;
    private int totalRecode;
    private List<T> pageData;
    private String url;

    public Page() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(int pageSize, int pageNumber, int totalRecode, List<T> pageData) {
        this.pageSize = pageSize;
        this.currentPage = pageNumber;
        this.totalRecode = totalRecode;
        this.pageData = pageData;
    }

    /**
     * 计算总页码数
     * @return totalPage
     */
    public int getTotalPage(){
        return totalRecode%pageSize==0? totalRecode/pageSize : totalRecode/pageSize+1;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalRecode=" + totalRecode +
                ", pageData=" + pageData +
                '}';
    }
}
