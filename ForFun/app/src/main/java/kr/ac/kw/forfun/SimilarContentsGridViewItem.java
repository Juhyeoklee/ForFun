package kr.ac.kw.forfun;


public class SimilarContentsGridViewItem {
    private String date;
    private int img;
    private String contentTitle;
    private String contentLocation;

    public void setDate(String date){
        this.date = date;
    }
    public void setImg(int img){
        this.img = img;
    }
    public void setContentTitle(String contentTitle){
        this.contentTitle = contentTitle;
    }
    public void setContentLocation(String contentLocation){
        this.contentLocation = contentLocation;
    }

    public String getDate(){ return this.date;}
    public int getImg() { return this.img; }
    public String getContentTitle() { return this.contentTitle; }
    public String getContentLocation() { return this.contentLocation; }
}