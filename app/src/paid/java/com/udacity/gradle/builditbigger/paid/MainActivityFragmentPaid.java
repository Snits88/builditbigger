package com.udacity.gradle.builditbigger.paid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.R;

public class MainActivityFragmentPaid extends MainActivityFragment {

    public MainActivityFragmentPaid() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        return root;
    }
}

