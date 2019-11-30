package kr.ac.kw.forfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;

import android.view.View;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;


public class RequestForFunActivity extends AppCompatActivity {
    private TabLayout mTabLayout;

    private Contents mContents;
    private User mUser;

    LinearLayout report;
    GridView content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_forfun);

        Intent intent = getIntent();

        mContents = (Contents) intent.getExtras().getSerializable("contents");
        mUser = (User) intent.getExtras().getSerializable("user");



        ImageView contentImg = findViewById(R.id.rqViewContentImg);
        ImageView userProfileImg = findViewById(R.id.requestForFunMateProfile);
        TextView bigTitle = findViewById(R.id.rqViewContentBigTitle);
        TextView smallTitle = findViewById(R.id.rqViewContentSmallTitle);
        TextView introduction = findViewById(R.id.rqViewContentIntroduction);
        TextView term = findViewById(R.id.rqViewContentTerm);
        TextView tag = findViewById(R.id.rqViewContentTag);
        TextView location = findViewById(R.id.rqViewContentLocation);


        report  = findViewById(R.id.reportView);
        content = findViewById(R.id.similarContentGridView);

        contentImg.setImageResource(mContents.getContentImg());
        userProfileImg.setImageResource(mUser.getUserProfileImg());

        bigTitle.setText(mContents.getContentName());
        smallTitle.setText(mContents.getContentName());
        introduction.setText(mContents.getContentIntroduction());
        term.setText(mContents.getContentTerm());
        tag.setText(mContents.getContentTag());
        location.setText(mContents.getContentLocation());

        userProfileImg.setBackground(new ShapeDrawable(new OvalShape()));
        userProfileImg.setClipToOutline(true);

        mTabLayout = findViewById(R.id.tabs);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        report.setVisibility(View.VISIBLE);
                        content.setVisibility(View.GONE);
                        break;
                    case 1:
                        report.setVisibility(View.GONE);
                        content.setVisibility(View.VISIBLE);
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        ListView listView;
        ReportListViewAdapter listViewAdapter;

        listViewAdapter = new ReportListViewAdapter();

        listView = (ListView) findViewById(R.id.reportListView);
        listView.setAdapter(listViewAdapter);

        listViewAdapter.addItem("역시 믿고 가는 그민페2222", "h8476***", "0", "34", "2019.11.02");
        listViewAdapter.addItem("그민페의 끝을잡", "w13***", "1", "30", "2019.11.02");
        listViewAdapter.addItem("음식값이 넘 비싸서 돌아버릴 뻔 했습니다.", "sco***", "5", "121", "2019.10.31");


        GridView gridView = (GridView) findViewById(R.id.similarContentGridView);
        SimilarContentsGridViewAdapter gridViewAdapter = new SimilarContentsGridViewAdapter();

        gridView.setAdapter(gridViewAdapter);
        gridViewAdapter.addItem("2019.11.18", R.drawable.play_cat,  "[연극]옥탑방고양이","서울 대학로 탄탄홀");
        gridViewAdapter.addItem("2019.10.26", R.drawable.design_festival, "[전시]서울디자인페스..","서울 COEX HALL C");
        gridViewAdapter.addItem("2019.09.17", R.drawable.caravan,  "[카라반]동훈카라반캠핑","경기 포천시 이동면");
        gridViewAdapter.addItem("2019.09.12", R.drawable.media_field, "[전시]미디어의장","서울 서울대학교미술관");

    }

}
