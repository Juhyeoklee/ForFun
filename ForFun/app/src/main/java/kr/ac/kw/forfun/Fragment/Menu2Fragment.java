package kr.ac.kw.forfun.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.kw.forfun.MyHeartForFunAdapter;
import kr.ac.kw.forfun.MyHeartForFunListItem;
import kr.ac.kw.forfun.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu2Fragment extends Fragment {


    public Menu2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu2, container, false);

        ArrayList<MyHeartForFunListItem> groupList = new ArrayList<MyHeartForFunListItem>();
        groupList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        groupList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        groupList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        groupList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        groupList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        groupList.add(new MyHeartForFunListItem("#제과제빵 #실습 #마카롱", "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));
        // Inflate the layout for this fragment

        RecyclerView group = v.findViewById(R.id.forfunGroupRcyView);
        MyHeartForFunAdapter groupAdapter = new MyHeartForFunAdapter(groupList);
        group.setAdapter(groupAdapter);
        group.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return v;
    }

}
