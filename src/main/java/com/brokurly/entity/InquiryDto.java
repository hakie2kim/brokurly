package com.brokurly.entity;

import java.util.Date;
import java.util.Objects;

public class InquiryDto {
    private String title;
    private Date reg_date;

    @Override
    public String toString() {
        return "inquiryDto{" +
                "title='" + title + '\'' +
                ", reg_date=" + reg_date +
                ", ans_stat='" + ans_stat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InquiryDto that = (InquiryDto) o;
        return Objects.equals(title, that.title) && Objects.equals(reg_date, that.reg_date) && Objects.equals(ans_stat, that.ans_stat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, reg_date, ans_stat);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getAns_stat() {
        return ans_stat;
    }

    public void setAns_stat(String ans_stat) {
        this.ans_stat = ans_stat;
    }

    private String ans_stat;

}