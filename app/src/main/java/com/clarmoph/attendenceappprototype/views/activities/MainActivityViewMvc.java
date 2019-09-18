package com.clarmoph.attendenceappprototype.views.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clarmoph.attendenceappprototype.R;

public class MainActivityViewMvc {

    private final View rootView;

    public MainActivityViewMvc(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.activity_main, parent, false);

    }

    public View getRootView() {
        return rootView.getRootView();
    }
}
