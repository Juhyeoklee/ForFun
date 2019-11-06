package kr.ac.kw.forfun;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import kr.ac.kw.forfun.ViewPage.Viewpage1;
import kr.ac.kw.forfun.ViewPage.Viewpage2;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm) {

        super(fm);


    }



    @Override

    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                Viewpage1 viewPage1 = new Viewpage1();

                return viewPage1;



            case 1:

                Viewpage2 viewPage2 = new Viewpage2();

                return viewPage2;


            default:

                return null;

        }

    }



    @Override

    public int getCount() {

        return 2;

    }
}
