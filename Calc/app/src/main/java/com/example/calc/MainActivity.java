package com.example.calc;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private String a;
    private int d, e;
    private String sign;
    FragmentCalc fragmentCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        fragmentCalc = new FragmentCalc();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_items, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.extended:
                        if(findViewById(R.id.fragment_layout) == null){
                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.main_layout, fragmentCalc)
                                    .commit();
                        }
                        break;
                    case R.id.plain:
                        getSupportFragmentManager().beginTransaction().remove(fragmentCalc).commit();
                        break;
                }
        return false;
    }

    public void click(View view){
        Button button = (Button)view;
        String b = button.getText().toString();
        switch (b){
            case "-": sign = "-";
            break;
            case "+": sign = "+";
            break;
            case "*": sign = "*";
            break;
            case "/": sign = "/";
            break;
//            case "sin":
//                double s = Integer.parseInt(String.valueOf(editText.getText()));
//                editText.setText(String.valueOf(Math.sin(s)));
//                a = "";
//                break;
            default:
                if (a != null){
                    String c = a + b;
                    editText.setText(c);
                    a = editText.getText().toString();
                } else {
                    editText.setText(b);
                    a = editText.getText().toString();
                }
        }
    }

    public void plus(View view){
                d = Integer.parseInt(editText.getText().toString());
                a = null;
                click(view);
    }

    public void equally(View view){
        if (!sign.equals("=")){
            e = Integer.parseInt(editText.getText().toString());
            switch (sign) {
                case "+":
                    editText.setText(String.valueOf(d + e));
                    break;
                case "-":
                    editText.setText(String.valueOf(d - e));
                    break;
                case "*":
                    editText.setText(String.valueOf(d * e));
                    break;
                case "/":
                    editText.setText(String.valueOf(d / e));
                    break;
            }
            sign = "=";
        }
        a = null;
        d = 0;
    }

    public void clickClear(View view){
        editText.setText(R.string.empty_text);
        a = null;
        d = 0;
        e = 0;
    }
}
