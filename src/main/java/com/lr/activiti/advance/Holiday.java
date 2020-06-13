package com.lr.activiti.advance;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 17:30
 */
public class Holiday implements Serializable {
    private Integer id;
    private String applicant;
    private Date beginDate;
    private Date endDate;
    private Float num;
    private String reason;
    private String type;

    public Holiday(Integer id, String applicant, Date beginDate, Date endDate, Float num, String reason, String type) {
        this.id = id;
        this.applicant = applicant;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.num = num;
        this.reason = reason;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
