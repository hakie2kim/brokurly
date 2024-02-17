package com.brokurly.service;

public class PageHandler {
    private int totalCnt;   //  총 게시물의 갯수
    private int pageSize;   //  한 페이지의 크기
    private int totalPage;  //  전체 페이지의 갯수
    private Integer page;   //  현재 페이지
    private boolean showPrev;   //  이전 페이지로 이동하는 링크를 보여줄 것인지 여부
    private boolean showNext;   //  다음 페이지로 이동하는 링크를 보여줄 것인지 여부

    private int naviSize = 10;  //  페이지 내비게이션의 크기
    private int beginPage;  //  내비게이션의 첫번째 페이지
    private int endPage;    //  내비게이션의 마지막 페이지

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public PageHandler(int totalCnt, Integer page) {
        this(totalCnt, page, 9);
    }

    public PageHandler(int totalCnt, Integer page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);
        beginPage = page / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    void print() {
        System.out.println("page = " + page);
        System.out.println(showPrev ? "[Prev] " : " ");
        for (int i = beginPage; i <= endPage; i++) {
            System.out.println(i + " ");
        }
        System.out.println(showNext ? " [Next]" : " ");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}

