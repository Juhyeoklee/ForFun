package kr.ac.kw.forfun.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.ac.kw.forfun.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu2Fragment extends Fragment {


    public Menu2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu2, container, false);

        // Inflate the layout for this fragment
        return view;
    }

}
