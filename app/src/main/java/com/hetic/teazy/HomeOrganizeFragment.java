package com.hetic.teazy;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Robin on 07/06/2017.
 */

public class HomeOrganizeFragment extends Fragment {
    public static HomeOrganizeFragment newInstance() {
        HomeOrganizeFragment fragment = new HomeOrganizeFragment();
        return fragment;
    }

    /*@Override
    public void onResume() {
        super.onResume();
        // Set title
        getActivity().getActionBar().setTitle(R.string.home_organize_title);
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_organize, container, false);
        View button = view.findViewById(R.id.button_organize_back);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Perform action on click
                getFragmentManager().popBackStack();

            }
        });
        View submit = view.findViewById(R.id.button_organize_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Perform action on click
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.frame_layout, HomeFriendsFragment.newInstance()).addToBackStack("HomeOrganize").commit();

            }
        });
        ActionBar actionBar = getActivity().getActionBar();
        return view;
    }


}