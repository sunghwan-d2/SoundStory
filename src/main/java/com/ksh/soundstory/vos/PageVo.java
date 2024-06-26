package com.ksh.soundstory.vos;

public class PageVo {
    private final int countPerPage = 5;
    private int totalCount;
    private int maxPage;
    private int minPage = 1;
    private int requestPage;
    private int selectOffset;

    public PageVo(int requestPage) {
        this.requestPage = Math.max(this.minPage, requestPage);
    }

    public int getRequestPage() {
        return requestPage;
    }

    public int getCountPerPage() {
        return countPerPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.maxPage = Math.max(this.minPage, this.totalCount / this.countPerPage + (this.totalCount % this.countPerPage == 0 ? 0 : 1));
        this.minPage = 1;
        this.requestPage = Math.min(this.requestPage, this.maxPage);
        this.selectOffset = this.countPerPage * (this.requestPage - 1);
    }

    public int getMaxPage() {
        return maxPage;
    }

    public int getMinPage() {
        return minPage;
    }

    public int getSelectOffset() {
        return selectOffset;
    }
}