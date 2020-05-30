package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    String name1;
    String name2;

    int a = 0;

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

        name1 = getIntent().getStringExtra("name1");
        name2 = getIntent().getStringExtra("name2");

        textView.setText(getString(R.string.turn, name1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item:
                Intent intent = new Intent(this, NameActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void click(View view){
        Button button = (Button)view;
        String b = button.getText().toString();

        if(b.equals("") && textView.getText().equals(getString(R.string.turn, name2))){
            button.setText(R.string.o);
            textView.setText(getString(R.string.turn, name1));
        } else if(b.equals("") && textView.getText().equals(getString(R.string.turn, name1))){
            button.setText(R.string.x);
            textView.setText(getString(R.string.turn, name2));
        }

        a++;
        if (a >= 5) check();
    }

    public void restart(View view){
        Toast.makeText(this, "Lets play again", Toast.LENGTH_SHORT).show();
        finish();
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
            textView.setText(getString(R.string.winner, name1));
            Toast.makeText(this, getString(R.string.winner, name1), Toast.LENGTH_SHORT).show();
        } else if(button11.getText().equals("O") && button21.getText().equals("O") && button31.getText().equals("O") ||
                button11.getText().equals("O") && button12.getText().equals("O") && button13.getText().equals("O") ||
                button11.getText().equals("O") && button22.getText().equals("O") && button33.getText().equals("O") ||
                button12.getText().equals("O") && button22.getText().equals("O") && button32.getText().equals("O") ||
                button13.getText().equals("O") && button22.getText().equals("O") && button31.getText().equals("O") ||
                button13.getText().equals("O") && button23.getText().equals("O") && button33.getText().equals("O") ||
                button21.getText().equals("O") && button22.getText().equals("O") && button23.getText().equals("O") ||
                button31.getText().equals("O") && button32.getText().equals("O") && button33.getText().equals("O")){
            textView.setText(getString(R.string.winner, name2));
            Toast.makeText(this, getString(R.string.winner, name2), Toast.LENGTH_SHORT).show();
        }
    }
}
