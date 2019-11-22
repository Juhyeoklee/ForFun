package kr.ac.kw.forfun.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.tabs.TabLayout;

import kr.ac.kw.forfun.ContentsPagerAdapter;
import kr.ac.kw.forfun.R;
import kr.ac.kw.forfun.ViewPage.Viewpage1;
import kr.ac.kw.forfun.ViewPage.Viewpage2;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu3Fragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Context mContext;
    private ContentsPagerAdapter mContentPagerAdapter;
    View view;

    Viewpage1 viewpage1 = new Viewpage1();
    Viewpage2 viewpage2 = new Viewpage2();

    //private FragmentManager fragmentManager;
    public Menu3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu1, container,false);
        mContext = view.getContext();

//        mTabLayout.addTab(mTabLayout.newTab().setText("AAAAA"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("BBBBB"));
        init();

        //mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                int pos = tab.getPosition();

                Fragment selected = null;

                switch (pos) {
                    case 0:
                        selected = viewpage1;

                        break;
                    case 1:
                        selected = viewpage2;

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

        //return inflater.inflate(R.layout.fragment_menu1, container, false);
        return view;
    }

    public void init(){
        mTabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mTabLayout.setupWithViewPager(mViewPager);

        mContentPagerAdapter = new ContentsPagerAdapter(getChildFragmentManager());

        init_pager();
    }

    private void init_pager(){
        mContentPagerAdapter.addItem(viewpage1, "TEST1");
        mContentPagerAdapter.addItem(viewpage2,"TEST2");
        Log.i("zzz", mContentPagerAdapter.getCount()+" ");


        mViewPager.setAdapter(mContentPagerAdapter);
    }
    @Override
    public void onStop() {
        super.onStop();
        mContentPagerAdapter.clearItem();
        mContentPagerAdapter.notifyDataSetChanged();;
        mViewPager.setAdapter(mContentPagerAdapter);
        Log.i("zzz", mContentPagerAdapter.getCount()+" ");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("test","test");
    }

    //    private View createTabView(String tabName) {
//
//        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
//
//        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
//
//        txt_name.setText(tabName);
//
//        return tabView;
//
//    }
}
