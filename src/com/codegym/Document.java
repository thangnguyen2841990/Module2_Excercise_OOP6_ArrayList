package com.codegym;

public class Document {
    protected int documentCode;
    protected String imprint;
    protected int releaseNumber;

    public Document() {
    }

    public Document(int documentCode, String imprint, int releaseNumber) {
        this.documentCode = documentCode;
        this.imprint = imprint;
        this.releaseNumber = releaseNumber;
    }

    public int getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(int documentCode) {
        this.documentCode = documentCode;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    @Override
    public String toString() {
        return this.documentCode + ", " + this.imprint + ", " + this.releaseNumber;
    }
}
