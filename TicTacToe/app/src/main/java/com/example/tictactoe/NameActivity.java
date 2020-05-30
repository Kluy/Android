package com.example.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;


import androidx.annotation.Nullable;

public class NameActivity extends Activity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
    }

    public void startGame(View view){
        if(editText1.getText().toString().equals("")){
            Toast.makeText(this, "Please enter first player name", Toast.LENGTH_SHORT).show();
        } else if (editText2.getText().toString().equals("")){
            Toast.makeText(this, "Please enter second player name", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("name1", editText1.getText().toString());
            intent.putExtra("name2", editText2.getText().toString());
            startActivity(intent);
        }
    }
}
