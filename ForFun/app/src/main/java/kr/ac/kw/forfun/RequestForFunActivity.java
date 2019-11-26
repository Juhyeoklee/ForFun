package kr.ac.kw.forfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.google.android.material.tabs.TabLayout;


public class RequestForFunActivity extends AppCompatActivity {
    private TabLayout mTabLayout;

    LinearLayout report;
    GridView content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_forfun);
        report  = findViewById(R.id.reportView);
        content = findViewById(R.id.similarContentGridView);


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
        listViewAdapter.addItem("역시 믿고 가는 그민페2222", "h8476***", "0", "34", "2019.11.02");
        listViewAdapter.addItem("그민페의 끝을잡", "w13***", "1", "30", "2019.11.02");
        listViewAdapter.addItem("음식값이 넘 비싸서 돌아버릴 뻔 했습니다.", "sco***", "5", "121", "2019.10.31");
        listViewAdapter.addItem("역시 믿고 가는 그민페2222", "h8476***", "0", "34", "2019.11.02");
        listViewAdapter.addItem("그민페의 끝을잡", "w13***", "1", "30", "2019.11.02");
        listViewAdapter.addItem("음식값이 넘 비싸서 돌아버릴 뻔 했습니다.", "sco***", "5", "121", "2019.10.31");

        GridView gridView = (GridView) findViewById(R.id.similarContentGridView);
        SimilarContentsGridViewAdapter gridViewAdapter = new SimilarContentsGridViewAdapter();

        gridView.setAdapter(gridViewAdapter);
        gridViewAdapter.addItem("2019.11.18", "[연극]옥탑방고양이","서울 대학로 탄탄홀");
        gridViewAdapter.addItem("2019.10.26", "[전시]서울디자인페스..","서울 COEX HALL C");
        gridViewAdapter.addItem("2019.09.17", "[카라반]동훈카라반캠핑","서울 COEX HALL C");
        gridViewAdapter.addItem("2019.09.12", "[전시]미디어의장","서울 서울대학교미술관");

    }

}
