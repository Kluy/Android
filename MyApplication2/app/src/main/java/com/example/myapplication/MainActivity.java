package com.example.myapplication;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    private TextView imageTagView;
    private EditText editText;
    private ImageView imageView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.android);
        linearLayout = findViewById(R.id.background);
        imageTagView = findViewById(R.id.imageTagView);

    }

    public void click(View view){

        if (view.getId() == R.id.buttonClean ){
            textView.setText(getString(R.string.hello));
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.android));
        } else {
            textView.setText(getString(R.string.helloName, editText.getText()));
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.android2));
        }

    }

    public void changeBackground(View view) {

        if(linearLayout.getBackground().getClass() == ColorDrawable.class) {

            if (((ColorDrawable) linearLayout.getBackground()).getColor() == getResources().getColor((R.color.white))) {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                linearLayout.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
    }

    public void imageClick(View view){
        imageTagView.setText(getResources().getString(R.string.imageTag));
    }

}
