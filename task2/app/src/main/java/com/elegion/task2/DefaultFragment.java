package com.elegion.task2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DefaultFragment extends Fragment {

    public static DefaultFragment newInstance() {
        DefaultFragment fragment = new DefaultFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.default_fragment, container, false);
    }
}

