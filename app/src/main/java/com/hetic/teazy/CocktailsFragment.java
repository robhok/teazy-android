package com.hetic.teazy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Robin on 07/06/2017.
 */

public class CocktailsFragment extends Fragment {
    public static CocktailsFragment newInstance() {
        CocktailsFragment fragment = new CocktailsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cocktails, container, false);
    }
}