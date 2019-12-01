package kr.ac.kw.forfun;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private int userProfileBgImg;
    private int userProfileImg;
    private String userName;
    private String userTag;
    private String userSelectLocation;
    private ArrayList<Contents> contentsList = new ArrayList<Contents>();

    public User(int userProfileBgImg, int userProfileImg, String userName, String userTag, String userSelectLocation, ArrayList<Contents> contentsList) {
        this.userProfileBgImg = userProfileBgImg;
        this.userProfileImg = userProfileImg;
        this.userName = userName;
        this.userTag = userTag;
        this.userSelectLocation = userSelectLocation;
        this.contentsList = contentsList;
    }

    public int getUserProfileBgImg() {
        return userProfileBgImg;
    }

    public void setUserProfileBgImg(int userProfileBgImg) {
        this.userProfileBgImg = userProfileBgImg;
    }

    public int getUserProfileImg() {
        return userProfileImg;
    }

    public void setUserProfileImg(int userProfileImg) {
        this.userProfileImg = userProfileImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public String getUserSelectLocation() {
        return userSelectLocation;
    }

    public void setUserSelectLocation(String userSelectLocation) {
        this.userSelectLocation = userSelectLocation;
    }

    public ArrayList<Contents> getContentsList() {
        return contentsList;
    }

    public void setContentsList(ArrayList<Contents> contentsList) {
        this.contentsList = contentsList;
    }

    public void addContents(Contents contents){
        contentsList.add(contents);
    }
    public void remove(Contents contents){
        contentsList.remove(contents);
    }
}
