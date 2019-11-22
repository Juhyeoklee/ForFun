package kr.ac.kw.forfun;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import kr.ac.kw.forfun.ViewPage.Viewpage1;
import kr.ac.kw.forfun.ViewPage.Viewpage2;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> list;
    ArrayList<String> title_list;
    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        title_list = new ArrayList<>();
    }

    public void addItem(Fragment item, String title){
        list.add(item);
        title_list.add(title);
    }
    @Override
    public Fragment getItem(int position) {

//        switch (position) {
//            case 0:
//                return list.get(0);
//
//            case 1:
//                return list.get(1);
//            default:
//                return null;
//        }
        return list.get(position);
    }

    public void clearItem(){
        list.clear();
        title_list.clear();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    // 이걸 해줘야 텍스트가 보임
    public CharSequence getPageTitle(int position) {
        return title_list.get(position);
    }
}
