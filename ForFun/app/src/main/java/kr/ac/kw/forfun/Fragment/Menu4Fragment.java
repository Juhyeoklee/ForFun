package kr.ac.kw.forfun.Fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.kw.forfun.MyHeartForFunAdapter;
import kr.ac.kw.forfun.MyHeartForFunListItem;
import kr.ac.kw.forfun.R;


public class Menu4Fragment extends Fragment {
    public Menu4Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu4, container, false);

        ArrayList<MyHeartForFunListItem> heartList = new ArrayList<MyHeartForFunListItem>();
        heartList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        heartList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        heartList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        heartList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        heartList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        heartList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));

        RecyclerView myHeartRcyView = (RecyclerView) v.findViewById(R.id.myHeartForFunRcyView);

        MyHeartForFunAdapter myHeartForFunAdapter = new MyHeartForFunAdapter(heartList);
        myHeartRcyView.setAdapter(myHeartForFunAdapter);
        myHeartRcyView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Inflate the layout for this fragment
        return v;
    }
}
