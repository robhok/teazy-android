package com.hetic.teazy;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by Robin on 07/06/2017.
 */

public class HomeFragment extends Fragment {
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showTimePickerDialog(View v) {
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.show(getActivity().getFragmentManager(), "timePicker");
    }
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        View button = view.findViewById(R.id.button_organize);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Perform action on click
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.frame_layout, HomeOrganizeFragment.newInstance()).addToBackStack("Home").commit();
            }
        });
        return view;
    }


}