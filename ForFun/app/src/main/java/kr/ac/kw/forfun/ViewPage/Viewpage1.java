package kr.ac.kw.forfun.ViewPage;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.ac.kw.forfun.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Viewpage1 extends Fragment {
    //private static Viewpage1 viewpage1;

    public Viewpage1() {
        // Required empty public constructor
    }

//    public static Viewpage1 getInstance(){
//        if(viewpage1 == null)
//            viewpage1 = new Viewpage1();
//
//        return viewpage1;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.viewpage1, container, false);
    }

}
