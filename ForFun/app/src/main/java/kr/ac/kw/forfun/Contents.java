package kr.ac.kw.forfun;

import java.io.Serializable;

public class Contents implements Serializable {
    private int contentImg;
    private String contentName;
    private String contentIntroduction;
    private String contentTerm;
    private String contentTag;
    private String contentLocation;

    public Contents(int contentImg, String contentName, String contentIntroduction, String contentTerm, String contentTag, String contentLocation) {
        this.contentImg = contentImg;
        this.contentName = contentName;
        this.contentIntroduction = contentIntroduction;
        this.contentTerm = contentTerm;
        this.contentTag = contentTag;
        this.contentLocation = contentLocation;
    }

    public int getContentImg() {
        return contentImg;
    }

    public void setContentImg(int contentImg) {
        this.contentImg = contentImg;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentIntroduction() {
        return contentIntroduction;
    }

    public void setContentIntroduction(String contentIntroduction) {
        this.contentIntroduction = contentIntroduction;
    }

    public String getContentTerm() {
        return contentTerm;
    }

    public void setContentTerm(String contentTerm) {
        this.contentTerm = contentTerm;
    }

    public String getContentTag() {
        return contentTag;
    }

    public void setContentTag(String contentTag) {
        this.contentTag = contentTag;
    }

    public String getContentLocation() {
        return contentLocation;
    }

    public void setContentLocation(String contentLocation) {
        this.contentLocation = contentLocation;
    }
}
