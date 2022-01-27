package com.codegym;

import java.io.Serializable;

public class Magazine extends Document implements Serializable {
    private int issueNumber;
    private int releaseMonth;

    public Magazine(int issueNumber, int releaseMonth) {
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public Magazine(int documentCode, String imprint, int releaseNumber, int issueNumber, int releaseMonth) {
        super(documentCode, imprint, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Số phát hành:  " + this.issueNumber + ", tháng phát hành: " + this.releaseMonth;
    }
}
