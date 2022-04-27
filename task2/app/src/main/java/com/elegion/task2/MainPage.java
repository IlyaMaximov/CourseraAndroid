package com.elegion.task2;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class MainPage extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return DefaultFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int messageContain = -1;

        switch (item.getItemId()) {
            case R.id.search:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragmentContainer, SearchFragment.newInstance())
                        .addToBackStack(SearchFragment.class.getName())
                        .commit();
                messageContain = R.string.settings;
                break;
            case R.id.settings:
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.fragmentContainer, SettingsFragment.newInstance())
                        .addToBackStack(SettingsFragment.class.getName())
                        .commit();
                messageContain = R.string.search;
                break;
            case R.id.exit:
                messageContain = R.string.exit;
        }

        if (messageContain != -1) {
            Toast.makeText(this, messageContain, Toast.LENGTH_SHORT).show();
            if (item.getItemId() == R.id.exit) {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
