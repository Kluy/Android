package com.example.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText editText;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button);

    }

    public void click(View view){
        String a = editText.getText().toString();
        Button button = (Button)view;
        String b = button.getText().toString();
        editText.setText(a + b);
    }

    public void clickClear(View view){
        editText.setText(R.string.empty_text);
    }
}
