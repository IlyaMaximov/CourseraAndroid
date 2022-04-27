package com.elegion.task2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SearchFragment extends Fragment {

    private SharedPreferencesHelper sharedPreferencesHelper;
    private EditText searchedString;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        searchedString = view.findViewById(R.id.searchedEditText);
        Button searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(searchButtonClickListener);
        return view;
    }

    private final View.OnClickListener searchButtonClickListener = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            String searchLine;
            switch (sharedPreferencesHelper.getSearchEngine()) {
                case R.id.google:
                    searchLine = "https://google.com/search?q=" + searchedString.getText().toString();
                    break;
                case R.id.bing:
                    searchLine = "https://bing.com/search?q=" + searchedString.getText().toString();
                    break;
                default:
                    searchLine = "https://www.yandex.ru/search?text=" + searchedString.getText().toString();
            }
            final Uri searchSiteURI = Uri.parse(searchLine);
            startActivity(new Intent(Intent.ACTION_VIEW, searchSiteURI));
        }
    };
}