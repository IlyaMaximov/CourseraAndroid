package com.elegion.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    public static String TEXT_MESSAGE = "TEXT_MESSAGE";
    private TextView mTextView;

    private final View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Uri googleSearchSiteURI = Uri.parse("https://www.google.com/search?q=" + mTextView.getText());
            startActivity(new Intent(Intent.ACTION_VIEW, googleSearchSiteURI));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        mTextView = findViewById(R.id.secondPageTextView);
        Button mButton = findViewById(R.id.secondPageButton);

        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(TEXT_MESSAGE));

        mButton.setOnClickListener(mButtonClickListener);
    }
}