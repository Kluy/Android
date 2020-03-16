package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity {

    private ListView listView;
    private ListView listView2;
    private ListView listView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        listView = findViewById(R.id.listView);
        listView2 = findViewById(R.id.listView2);
        listView4 = findViewById(R.id.listView4);

        List<Car> cars4 = cars4();
        CarAdapter carAdapter = new CarAdapter(this, cars4);

        String [] cars = {"BMW", "Porsche", "Maybach"};
        String [] cars2 = getResources().getStringArray(R.array.cars);
        List<String> cars3  = cars();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars3);
        listView.setAdapter(arrayAdapter);
        listView2.setAdapter(arrayAdapter2);
        listView4.setAdapter(carAdapter);
    }

    public List<String> cars(){
        List<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Porsche");
        cars.add("Maybach");
        return cars;
    }

    private List<Car> cars4(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW",210,3.4));
        cars.add(new Car("Porsche",310,4.2));
        cars.add(new Car("Maybach",250,2.4));
        return cars;
    }
}
