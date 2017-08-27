package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * Created by admin on 26.08.17.
 */
@XmlRootElement
public class FilterRequest {

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateFrom;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateFrom;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTo;

    @NotNull
    private Integer pageNumber;

    @NotNull
    private Integer pages;


    public FilterRequest() {
    }

    public FilterRequest(LocalDateTime startDateFrom, LocalDateTime startDateTo, LocalDateTime endDateFrom, LocalDateTime endDateTo, Integer pageNumber, Integer pages) {
        this.startDateFrom = startDateFrom;
        this.startDateTo = startDateTo;
        this.endDateFrom = endDateFrom;
        this.endDateTo = endDateTo;
        this.pageNumber = pageNumber;
        this.pages = pages;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public LocalDateTime getStartDateFrom() {
        return startDateFrom;
    }

    public void setStartDateFrom(LocalDateTime startDateFrom) {
        this.startDateFrom = startDateFrom;
    }

    public LocalDateTime getStartDateTo() {
        return startDateTo;
    }

    public void setStartDateTo(LocalDateTime startDateTo) {
        this.startDateTo = startDateTo;
    }

    public LocalDateTime getEndDateFrom() {
        return endDateFrom;
    }

    public void setEndDateFrom(LocalDateTime endDateFrom) {
        this.endDateFrom = endDateFrom;
    }

    public LocalDateTime getEndDateTo() {
        return endDateTo;
    }

    public void setEndDateTo(LocalDateTime endDateTo) {
        this.endDateTo = endDateTo;
    }

    @Override
    public String toString() {
        return "FilterRequest{" +
                "startDateFrom=" + startDateFrom +
                ", startDateTo=" + startDateTo +
                ", endDateFrom=" + endDateFrom +
                ", endDateTo=" + endDateTo +
                ", pageNumber=" + pageNumber +
                ", pages=" + pages +
                '}';
    }
}
