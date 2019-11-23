package kr.ac.kw.forfun;

public class ReportListViewItem {
    private String reportTitle;
    private String reportId;
    private String commentCount;
    private String viewCount;
    private String reportDate;

    public void setReportTitle(String reportTitle){
        this.reportTitle = reportTitle;
    }
    public void setReportId(String reportId){
        this.reportId = reportId;
    }
    public void setCommentCount(String commentCount){
        this.commentCount = commentCount;
    }
    public void setViewCount(String viewCount){
        this.viewCount = viewCount;
    }
    public void setReportDate(String reportDate){
        this.reportDate = reportDate;
    }

    public String getReportTitle(){
        return this.reportTitle;
    }
    public String getReportId(){
        return this.reportId;
    }
    public String getCommentCount(){
        return this.commentCount;
    }
    public String getViewCount(){
        return  this.viewCount;
    }
    public String getReportDate(){
        return this.reportDate;
    }
}

