package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button11;
    Button button12;
    Button button13;
    Button button21;
    Button button22;
    Button button23;
    Button button31;
    Button button32;
    Button button33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
    }

    public void click(View view){
        Button button = (Button)view;
        String b = button.getText().toString();
        if(b.equals("")){
            change(button);
            check();
        }
    }

    public void clear(View view){
        button11.setText(R.string.empty_text);
        button12.setText(R.string.empty_text);
        button13.setText(R.string.empty_text);
        button21.setText(R.string.empty_text);
        button22.setText(R.string.empty_text);
        button23.setText(R.string.empty_text);
        button31.setText(R.string.empty_text);
        button32.setText(R.string.empty_text);
        button33.setText(R.string.empty_text);
        textView.setText(R.string.turn_x);
    }

    public void change(Button button){
        if(textView.getText().equals("O turn")){
            button.setText(R.string.o);
            textView.setText(R.string.turn_x);
        } else if(textView.getText().equals("X turn")) {
            button.setText(R.string.x);
            textView.setText(R.string.turn_o);
        }
    }

    public void check(){
        if(button11.getText().equals("X") && button21.getText().equals("X") && button31.getText().equals("X") ||
                button11.getText().equals("X") && button12.getText().equals("X") && button13.getText().equals("X") ||
                button11.getText().equals("X") && button22.getText().equals("X") && button33.getText().equals("X") ||
                button12.getText().equals("X") && button22.getText().equals("X") && button32.getText().equals("X") ||
                button13.getText().equals("X") && button22.getText().equals("X") && button31.getText().equals("X") ||
                button13.getText().equals("X") && button23.getText().equals("X") && button33.getText().equals("X") ||
                button21.getText().equals("X") && button22.getText().equals("X") && button23.getText().equals("X") ||
                button31.getText().equals("X") && button32.getText().equals("X") && button33.getText().equals("X")){
            textView.setText(R.string.x_win);
        } else if(button11.getText().equals("O") && button21.getText().equals("O") && button31.getText().equals("O") ||
                button11.getText().equals("O") && button12.getText().equals("O") && button13.getText().equals("O") ||
                button11.getText().equals("O") && button22.getText().equals("O") && button33.getText().equals("O") ||
                button12.getText().equals("O") && button22.getText().equals("O") && button32.getText().equals("O") ||
                button13.getText().equals("O") && button22.getText().equals("O") && button31.getText().equals("O") ||
                button13.getText().equals("O") && button23.getText().equals("O") && button33.getText().equals("O") ||
                button21.getText().equals("O") && button22.getText().equals("O") && button23.getText().equals("O") ||
                button31.getText().equals("O") && button32.getText().equals("O") && button33.getText().equals("O")){
            textView.setText(R.string.o_win);
        }
    }
}
