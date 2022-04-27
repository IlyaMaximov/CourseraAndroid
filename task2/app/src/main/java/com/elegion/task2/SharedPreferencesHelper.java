package com.elegion.task2;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String SEARCH_ENGINE_KEY = "SEARCH_ENGINE_KEY";

    private final SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getSearchEngine() {
        return mSharedPreferences.getInt(SEARCH_ENGINE_KEY,R.id.yandex);
    }

    public void setSearchEngine(int setting) {
        mSharedPreferences.edit().putInt(SEARCH_ENGINE_KEY, setting).apply();
    }
}
