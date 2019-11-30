package kr.ac.kw.forfun;

public class Group {
    private Contents contents;
    private String tag;
    private String title;
    private String hostName;

    public Group(Contents contents, String tag, String title, String hostName) {
        this.contents = contents;
        this.tag = tag;
        this.title = title;
        this.hostName = hostName;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
