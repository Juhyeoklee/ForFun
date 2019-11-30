package kr.ac.kw.forfun.Fragment;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.ac.kw.forfun.Contents;
import kr.ac.kw.forfun.ForFunMateAdapter;
import kr.ac.kw.forfun.ForFunMateItem;
import kr.ac.kw.forfun.MainActivity;
import kr.ac.kw.forfun.R;
import kr.ac.kw.forfun.StoryAdapter;
import kr.ac.kw.forfun.User;


public class Menu1Fragment extends Fragment {

    private ArrayList<User> mUserList = new ArrayList<User>();
    private ArrayList<Contents> mContentsList = new ArrayList<Contents>();
    private ArrayList<ForFunMateItem> matelist = new ArrayList<ForFunMateItem>();;

    public Menu1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d("OnAttach", "Fragment1 OnAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matelist.clear();
        mContentsList.clear();
        mUserList.clear();

        setData();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_menu3, container, false);
        // Inflate the layout for this fragment


        RecyclerView storyView = (RecyclerView) v.findViewById(R.id.storyRecyclerView);
        storyView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        StoryAdapter storyAdapter = new StoryAdapter(mUserList);
        storyView.setAdapter(storyAdapter);

        RecyclerView forFunMate =(RecyclerView) v.findViewById(R.id.forfunMateRcyView);
        forFunMate.setLayoutManager(new LinearLayoutManager(getContext()));

        ForFunMateAdapter forFunMateAdapter = new ForFunMateAdapter(matelist);
        forFunMate.setAdapter(forFunMateAdapter);
        forFunMate.setNestedScrollingEnabled(false);


        return v;


    }

    private void setData(){
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
        ArrayList<Contents> user1ContentsList = new ArrayList<Contents>();
        user1ContentsList.add(contents2);
        user1ContentsList.add(contents3);

        ArrayList<Contents> user2ContentsList = new ArrayList<Contents>();
        user2ContentsList.add(contents1);
        user2ContentsList.add(contents3);

        ArrayList<Contents> user3ContentsList = new ArrayList<Contents>();
        user3ContentsList.add(contents1);
        user3ContentsList.add(contents2);

        ArrayList<Contents> user4ContentsList = new ArrayList<Contents>();
        user4ContentsList.add(contents1);
        user4ContentsList.add(contents2);
        user4ContentsList.add(contents3);

        mContentsList.add(contents1);
        mContentsList.add(contents2);
        mContentsList.add(contents3);

        mUserList.add(new User(R.drawable.profilebg1, R.drawable.profile1, "이주혁", "#공연#하이킹#낚시","서울전체", user1ContentsList));
        mUserList.add(new User(R.drawable.profilebg2, R.drawable.profile2, "원세영", "#공연#전시/행사#독서","전체", user2ContentsList));

        mUserList.add(new User(R.drawable.profilebg3, R.drawable.profile3, "민경원", "#공연","전체", user3ContentsList));

        mUserList.add(new User(R.drawable.profilebg4, R.drawable.profile4, "허채원", "#공연#방탈출","전체", user4ContentsList));

        mUserList.add(new User(R.drawable.profilebg4, R.drawable.profile4, "허채원", "#공연#방탈출","전체", user4ContentsList));

        mUserList.add(new User(R.drawable.profilebg4, R.drawable.profile4, "허채원", "#공연#방탈출","전체", user4ContentsList));

        mUserList.add(new User(R.drawable.profilebg4, R.drawable.profile4, "허채원", "#공연#방탈출","전체", user4ContentsList));

        matelist.add(new ForFunMateItem(mContentsList.get(0), mUserList.get(0)));
        matelist.add(new ForFunMateItem(mContentsList.get(1), mUserList.get(1)));
        matelist.add(new ForFunMateItem(mContentsList.get(2), mUserList.get(2)));
        matelist.add(new ForFunMateItem(mContentsList.get(0), mUserList.get(3)));
    }

    private void firstAction(){
        (new AsyncTask<Menu1Fragment, Void, Menu1Fragment>(){
            @Override
            protected Menu1Fragment doInBackground(Menu1Fragment... params) {
                return params[0];
            }

            @Override
            protected void onPostExecute(Menu1Fragment result) {
                result.setData();
            }

        }).execute(this);
    }
    private void setUI(){

    }

}
