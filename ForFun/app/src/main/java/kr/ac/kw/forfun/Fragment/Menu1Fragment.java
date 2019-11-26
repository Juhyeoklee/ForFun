package kr.ac.kw.forfun.Fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.kw.forfun.ForFunMateAdapter;
import kr.ac.kw.forfun.ForFunMateItem;
import kr.ac.kw.forfun.R;
import kr.ac.kw.forfun.StoryAdapter;


public class Menu1Fragment extends Fragment {

    public Menu1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_menu3, container, false);
        // Inflate the layout for this fragment
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("내 펀 스토리");
        nameList.add("17 타일러");
        nameList.add("17 타일러");
        nameList.add("17 타일러");
        nameList.add("17 타일러");
        nameList.add("17 타일러");
        nameList.add("17 타일러");
        nameList.add("17 타일러");
        nameList.add("17 타일러");

        ArrayList<ForFunMateItem> matelist = new ArrayList<ForFunMateItem>();
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공연 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공연 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공연 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공연 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공연 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공연 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));
        matelist.add(new ForFunMateItem("그랜드 민트 페스티벌", "#공 #페스티벌", "이세혁","#공연 #하이킹 #낚시"));

        RecyclerView storyView = (RecyclerView) v.findViewById(R.id.storyRecyclerView);
        storyView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        StoryAdapter storyAdapter = new StoryAdapter(nameList);
        storyView.setAdapter(storyAdapter);

        RecyclerView forFunMate =(RecyclerView) v.findViewById(R.id.forfunMateRcyView);
        forFunMate.setLayoutManager(new LinearLayoutManager(getContext()));

        ForFunMateAdapter forFunMateAdapter = new ForFunMateAdapter(matelist);
        forFunMate.setAdapter(forFunMateAdapter);
        forFunMate.setNestedScrollingEnabled(false);


        return v;


    }




}
