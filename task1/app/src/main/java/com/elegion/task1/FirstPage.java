package com.elegion.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    private EditText mEditText;

    private final View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isMessageExist()) {
                showMessage(mEditText.getText().toString());
                Intent intent = new Intent(FirstPage.this, SecondPage.class);
                intent.putExtra(SecondPage.TEXT_MESSAGE, mEditText.getText().toString());
                startActivity(intent);
            }
        }
    };

    private boolean isMessageExist() {
        return !TextUtils.isEmpty(mEditText.getText());
    }

    private void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        mEditText = findViewById(R.id.firstPageTextEditor);
        Button mButton = findViewById(R.id.firstPageButton);

        mButton.setOnClickListener(mButtonClickListener);
    }
}