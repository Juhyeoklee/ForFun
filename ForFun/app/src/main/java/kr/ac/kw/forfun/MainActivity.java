package kr.ac.kw.forfun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import kr.ac.kw.forfun.Fragment.Menu3Fragment;
import kr.ac.kw.forfun.Fragment.Menu2Fragment;
import kr.ac.kw.forfun.Fragment.Menu1Fragment;
import kr.ac.kw.forfun.Fragment.Menu4Fragment;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private FragmentManager fragmentManager = getSupportFragmentManager();

    // 4개의 메뉴에 들어갈 Fragment들
    private Menu1Fragment menu1Fragment = new Menu1Fragment();
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    private Menu3Fragment menu3Fragment = new Menu3Fragment();
    private Menu4Fragment menu4Fragment = new Menu4Fragment();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.actionbar_actions, menu) ;

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home: { // 뒤로가기 버튼 눌렀을 때
//                finish();
//                return true;
//            }
//            case R.id.actionbar_search: { // 오른쪽 상단 버튼 눌렀을 때
//                Toast.makeText(this, "검색", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar) findViewById(R.id.app_toolbar) ;
        setSupportActionBar(tb);
        // ↓툴바에 홈버튼을 활성화
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.ic_bell_24dp); //뒤로가기 버튼 이미지 지정




    // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_layout, menu1Fragment).commitAllowingStateLoss();

        // 버튼 클릭시 사용되는 리스너를 구현합니다.

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_main_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                      //  FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Fragment frag = null;
                        // 어떤 메뉴 아이템이 터치되었는지 확인합니다.
                        switch (item.getItemId()) {

                            case R.id.menuitem_bottombar_home: {
                                frag = menu1Fragment;
                             //   transaction.replace(R.id.fragment_layout, frag).commitAllowingStateLoss();

                                break;
                            }
                            case R.id.menuitem_bottombar_people: {
                                frag = menu2Fragment;
                             //   transaction.replace(R.id.fragment_layout, frag).commitAllowingStateLoss();


                                break;
                            }
                            case R.id.menuitem_bottombar_content: {
                                frag = menu3Fragment;
                              //  transaction.replace(R.id.fragment_layout, frag).commitAllowingStateLoss();


                                break;
                            }
                            case R.id.menuitem_bottombar_forfun: {
                                frag = menu4Fragment;
                               // transaction.replace(R.id.fragment_layout, frag).commitAllowingStateLoss();
                                break;
                            }
                        } // switch

                        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,frag).commit();
                        fragmentManager.beginTransaction().replace(R.id.fragment_layout,frag).commitNow();
                        return true;
                    }
                });

    }


}
