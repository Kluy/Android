package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {
    private List<Car> cars;
    private LayoutInflater layoutInflater;

    public CarAdapter(Context context, List<Car> cars) {
        this.cars = cars;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = layoutInflater.inflate(R.layout.list_items,parent,false);
        }

        Car car = (Car) getItem(position);

        TextView carName = view.findViewById(R.id.car_name);
        TextView carSpeed = view.findViewById(R.id.car_speed);
        TextView carEngine = view.findViewById(R.id.car_engine);

        carName.setText(view.getResources().getString(R.string.model, car.getModel()));
        carSpeed.setText(view.getResources().getString(R.string.speed, String.valueOf(car.getMaxSpeed())));
        carEngine.setText(view.getResources().getString(R.string.engine, String.valueOf(car.getEngineValue())));

        return view;
    }
}
