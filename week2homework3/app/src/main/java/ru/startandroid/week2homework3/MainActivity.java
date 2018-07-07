package ru.startandroid.week2homework3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        List<Person> list = new ArrayList<>();
        initList(list);
        MyAdapter myAdapter = new MyAdapter(list, this);
        rv.setAdapter(myAdapter);
    }

    private List initList(List<Person> list){
        list.add(new Person(R.drawable.elizabeth, "Elizabeth", "In Search"));
        list.add(new Person(R.drawable.scarlett, "Scarlett", "Married"));
        list.add(new Person(R.drawable.margo, "Margo", "Married"));
        list.add(new Person(R.drawable.jenifer, "Jenifer", "Beloved"));
        list.add(new Person(R.drawable.kira, "Elizabeth", "Lesbian"));
        list.add(new Person(R.drawable.aniston, "Gal", "Married"));
        return list;
    }
}
