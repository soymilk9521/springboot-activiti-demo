package com.lr.activiti.advance;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 14:28
 */

public class User implements Serializable {
    private String applicant;
    private String approval;

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
}
