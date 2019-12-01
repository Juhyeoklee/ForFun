package kr.ac.kw.forfun.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kw.forfun.Adapter.ContentsPagerAdapter;
import kr.ac.kw.forfun.Class.Content;
import kr.ac.kw.forfun.R;
import kr.ac.kw.forfun.Class.User;
import kr.ac.kw.forfun.ViewPage.Viewpage1;
import kr.ac.kw.forfun.ViewPage.Viewpage2;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu3Fragment extends Fragment {
    String TAG = "WSY";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Context mContext;
    private ContentsPagerAdapter mContentPagerAdapter;
    private View view;

    Viewpage1 viewpage1 = new Viewpage1();
    Viewpage2 viewpage2 = new Viewpage2();

    //private FragmentManager fragmentManager;
    public Menu3Fragment() {
        // Required empty public constructor
    }

   // private ArrayList<ArrayList<Content>> allContentList = new ArrayList<>();


    Context context;

    //생성된 FirebaseStorage를 참조하는 storage 생성
    FirebaseStorage storage;
    StorageReference storageRef;
    StorageReference pathReference;
    FirebaseFirestore firestore;


    Map<String, Map> data = new HashMap<>();

    Map<String, String> imageName = new HashMap<>();

    ArrayList<String> name = new ArrayList<>();


    TextView inputName;
    String key;

    ArrayList<Content> movieList1 = new ArrayList();
    int i = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu3, container,false);
        mContext = view.getContext();

        // 다시 이 프래그먼트로 돌아올때 취미 이름 갯수를 초기화해서 보여주기 위해


        init();


        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                int pos = tab.getPosition();

                Fragment selected = null;

                switch (pos) {
                    case 0:
                        selected = viewpage1;
                        Log.d(TAG, "onTabSelected: ");
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

        //return inflater.inflate(R.layout.fragment_menu3, container, false);
        return view;
    }

    private void init(){
        mTabLayout = view.findViewById(R.id.tablayout);
        mViewPager = view.findViewById(R.id.viewpager);
        mTabLayout.setupWithViewPager(mViewPager);

        mContentPagerAdapter = new ContentsPagerAdapter(getChildFragmentManager());

        init_pager();
    }

    private void init_pager(){
        mContentPagerAdapter.addItem(viewpage1, "콘텐츠 모아보기");
        mContentPagerAdapter.addItem(viewpage2,"친구 모아보기");
        Log.i("zzz", mContentPagerAdapter.getCount()+" ");


        mViewPager.setAdapter(mContentPagerAdapter);
    }
    @Override
    public void onStop() {
        super.onStop();
        mContentPagerAdapter.clearItem();
        mContentPagerAdapter.notifyDataSetChanged();
        mViewPager.setAdapter(mContentPagerAdapter);
        Log.i("zzz", mContentPagerAdapter.getCount()+" ");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        User.contentCount = 0;
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
