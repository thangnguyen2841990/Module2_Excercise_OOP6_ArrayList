package com.codegym;

import java.io.Serializable;

public class NewsPaper extends Document implements Serializable {
    private int releaseDate;

    public NewsPaper(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public NewsPaper(int documentCode, String imprint, int releaseNumber, int releaseDate) {
        super(documentCode, imprint, releaseNumber);
        this.releaseDate = releaseDate;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Ngày phát hành" + this.releaseDate;
    }
}
