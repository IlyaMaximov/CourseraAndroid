package com.elegion.task2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class SettingsFragment extends Fragment {
    private SharedPreferencesHelper preferencesHelper;

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        preferencesHelper = new SharedPreferencesHelper(getActivity());
        RadioGroup radioGroup = view.findViewById(R.id.searchEngineRadioButton);
        radioGroup.check(preferencesHelper.getSearchEngine());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                preferencesHelper.setSearchEngine(id);
            }
        });
        return view;
    }
}