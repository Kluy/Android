package com.example.picturechoose;

import androidx.fragment.app.FragmentActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Button button;
    private ImageView imageView;
    FragmentPicture fragmentPicture;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
        fragmentPicture = new FragmentPicture();
    }

    @Override
    public void onClick(View view) {
        if (findViewById(R.id.fragment_layout) == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.linear_layout, fragmentPicture)
                .commit();
        button.setVisibility(View.INVISIBLE);
        }
    }

    public void setImage(View view){
        Drawable drawable = imageView.getDrawable();
        imageView.setImageDrawable(drawable);
        getSupportFragmentManager().beginTransaction().remove(fragmentPicture).commit();
        button.setVisibility(View.VISIBLE);
    }

    public void clickRight(View view){
        if (i < 3){
            i++;
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.a + i));
        }
    }

    public void clickLeft(View view){
        if(i > 0) {
            i--;
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.a + i));
        }
    }
}
