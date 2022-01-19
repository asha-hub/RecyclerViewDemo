package com.example.recyclerviewwithmultipleviewtypes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerviewwithmultipleviewtypes.adapter.TripAdapter;
import com.example.recyclerviewwithmultipleviewtypes.models.Ads;
import com.example.recyclerviewwithmultipleviewtypes.models.Item;
import com.example.recyclerviewwithmultipleviewtypes.models.News;
import com.example.recyclerviewwithmultipleviewtypes.models.Trip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Item> items = new ArrayList<>();

        Trip trip1 =new Trip((R.drawable.banglore),"Banglore","summer 2022  - 10 days");
        items.add(new Item(0,trip1));

        Ads ads1 = new Ads("Christmas Holiday","70% off on chrismas sale");
        items.add(new Item(1,ads1));

        News news1 = new News("Banglore,Manglore","flash flash flashflashflashflashflashfflash flash flash flash flash flash ");
        items.add(new Item(2,news1));

        Trip trip2 =new Trip((R.drawable.maldives),"Maldives","winter 2022  - 5 days");
        items.add(new Item(0,trip2));

        News news2 = new News("Maldives beach","news newsnewsnewsnewsnewsnewsnewsnews newsnewsnewsnewsnewsnewsnewsnewsnewsnews ");
        items.add(new Item(2,news2));

        Trip trip3 =new Trip((R.drawable.hyd),"Hyd"," winter 2022  - 3 days");
        items.add(new Item(0,trip3));

        News news3 = new News("Charminar","newsflash newsnews flash newsnewsnewsnewsnewsnewsflash newsnewsnewsnewsnewewsnewsnews ");
        items.add(new Item(2,news3));

        Trip trip4 =new Trip((R.drawable.a_dog),"Mumbai"," winter 2022  - 1 days");
        items.add(new Item(0,trip4));

        News news4 = new News("Gate way of India","newsflash newsnews flash newsnewsnewsnewsnewsnewsflash newsnewsnewsnewsnewewsnewsnews ");
        items.add(new Item(2,news4));

        recyclerView.setAdapter(new TripAdapter(items,this));
    }
}