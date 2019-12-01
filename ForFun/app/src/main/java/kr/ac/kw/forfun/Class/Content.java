package kr.ac.kw.forfun.Class;

import android.net.Uri;

public class Content {
    private String type;
    private String title;
    private Uri ResourceID;

    public Content(Uri id, String title)
    {
        this.type = type;
        this.ResourceID = id;
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public Uri getResourceID() {
        return ResourceID;
    }
}
