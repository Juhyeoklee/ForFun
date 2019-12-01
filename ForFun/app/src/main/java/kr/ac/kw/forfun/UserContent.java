package kr.ac.kw.forfun;

import java.util.ArrayList;

import kr.ac.kw.forfun.Class.Content;

public class UserContent {
    static ArrayList<Content> contents = new ArrayList<>(); // 모든 컨텐츠가 들어있음. Content 클래스의 type 속성으로 구분하기

    public int contentsSize(){
        return contents.size();
    }

    public ArrayList<Content> getContent(){
        return contents;
    }
}
