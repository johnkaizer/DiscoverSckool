package com.project.discoverskool.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.project.discoverskool.Adapters.HighAdapter;
import com.project.discoverskool.Database.DBmain;
import com.project.discoverskool.Model;
import com.project.discoverskool.R;

import java.util.ArrayList;

public class HighActivity extends AppCompatActivity {
    ImageView back;
    RecyclerView recyclerView;
    ArrayList<Model> modelArrayList;
    HighAdapter highAdapter;
    DBmain dBmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high);
        modelArrayList = new ArrayList<>();
        dBmain = new DBmain(this);
        highAdapter = new HighAdapter(HighActivity.this, modelArrayList);
        recyclerView=findViewById(R.id.highrecylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(highAdapter);
        Cursor cursor = new DBmain(this).readhighdata();
        while (cursor.moveToNext()){
            Model model = new Model(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));
            modelArrayList.add(model);
        }
        back =findViewById(R.id.return_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HighActivity.this, CategoriesActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}