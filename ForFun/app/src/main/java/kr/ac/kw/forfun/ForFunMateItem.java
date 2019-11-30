package kr.ac.kw.forfun;

public class ForFunMateItem {
    private Contents contents;
    private User user;

    public ForFunMateItem(Contents contents, User user) {
        this.contents = contents;
        this.user = user;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}