package com.example.domxml;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntroActivity extends Activity {
    public static final String EXTRA_SEARCH = "com.example.domxml.EXTRA_SEARCH";
    public String search = "";
    private TextView textView;
    private EditText editText;
    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
    }


    public void onClick(View view){
        search = editText.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_SEARCH,search);
        startActivity(intent);
    }
}
