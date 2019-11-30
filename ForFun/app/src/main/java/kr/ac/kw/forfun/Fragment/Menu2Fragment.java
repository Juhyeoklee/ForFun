package kr.ac.kw.forfun.Fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.kw.forfun.Contents;
import kr.ac.kw.forfun.Group;
import kr.ac.kw.forfun.MyHeartForFunAdapter;
import kr.ac.kw.forfun.MyHeartForFunListItem;
import kr.ac.kw.forfun.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu2Fragment extends Fragment {
    ArrayList<Group> groupList = new ArrayList<Group>();

    public Menu2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groupList.clear();

        setDate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu2, container, false);


        // Inflate the layout for this fragment

        RecyclerView group = v.findViewById(R.id.forfunGroupRcyView);
        MyHeartForFunAdapter groupAdapter = new MyHeartForFunAdapter(groupList);
        group.setAdapter(groupAdapter);
        group.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return v;
    }
    private void setDate(){
        Contents contents1 = new Contents(R.drawable.grand_mint_frestival, "그랜드민트페스티벌",
                "캐릭터를 활용한 판타지 좀 더 다양하고 과감해질 MD(머천다이징) 4개의 공식 스테이지 + 다양한 이벤트존 새로운 아티스트, 밴드의 비중 강화",
                "10. 19(sat) – 10. 20(sun)",
                "#문화#공연#밴드#페스티벌",
                "올림픽공원");
        Contents contents2 = new Contents(R.drawable.play_cat, "옥탑방 고양이",
                "대학로 최고의 연극 “옥탑방고양이”인터파크 평점 9.5! 200만 관객의 선택!재관람관객 2만명 돌파!창작연극 사상 최초 7년 연속 연극 예매율 “1위”일반 로맨틱코미디와 차별화된 옥탑방고양이",
                "11. 10(sat) – 12. 20(sun)",
                "#공연#연극",
                "올림픽공원");
        Contents contents3 = new Contents(R.drawable.dialog_in_the_dark, "DIALOGUE IN THE DARK",
                "완전한 어둠 속에 꾸며진 7개 테마를 로드마스터와 함께 100분간 시각 이외의 감각으로 체험하는 신비롭고 이색적인 능동적 참여형 체험 전시",
                "10.01(sat) ~ ",
                "#공연#전시",
                "서울 종로구 북촌로 71");
        groupList.add(new Group(contents1, contents1.getContentTag(), "그랜드 민트 페스티벌 고고", "허채원"));
        groupList.add(new Group(contents2, contents2.getContentTag(), "연극 보러가실부우운", "이주혁"));
        groupList.add(new Group(contents3, contents3.getContentTag(), "일요일에 나랑 같이 마카롱 만들 분", "김탁구"));



    }

}
