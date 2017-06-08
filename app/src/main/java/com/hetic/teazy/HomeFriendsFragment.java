package com.hetic.teazy;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

/**
 * Created by Robin on 07/06/2017.
 */

public class HomeFriendsFragment extends Fragment {
    public static HomeFriendsFragment newInstance() {
        HomeFriendsFragment fragment = new HomeFriendsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_addfriends, container, false);
        View button = view.findViewById(R.id.button_friends_submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Perform action on click
                getFragmentManager().popBackStack();

            }
        });
        return view;
    }
}