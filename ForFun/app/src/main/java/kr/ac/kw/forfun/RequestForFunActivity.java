package kr.ac.kw.forfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.LinearLayout;
import android.widget.ListView;


import com.google.android.material.tabs.TabLayout;


public class RequestForFunActivity extends AppCompatActivity {
    private TabLayout mTabLayout;

    LinearLayout report;
    LinearLayout content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_forfun);
        report  = findViewById(R.id.reportView);
        content = findViewById(R.id.contentsView);


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

    }

}
