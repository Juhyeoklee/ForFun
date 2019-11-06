package kr.ac.kw.forfun.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import kr.ac.kw.forfun.ContentsPagerAdapter;
import kr.ac.kw.forfun.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1Fragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Context mContext;
    private Context context;
    private ContentsPagerAdapter mContentPagerAdapter;

    private FragmentActivity myContext;

    public Menu1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        myContext=(FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu1, container);

//        mContext = view.getContext();
//        context = mContext.getApplicationContext();
        mTabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);


//        mTabLayout.addTab(mTabLayout.newTab().setText("AAAAA"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("BBBBB"));
//
//
//        mContentPagerAdapter = new ContentsPagerAdapter(myContext.getSupportFragmentManager());
//
//        mViewPager.setAdapter(mContentPagerAdapter);
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        return inflater.inflate(R.layout.fragment_menu1, container, false);
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
