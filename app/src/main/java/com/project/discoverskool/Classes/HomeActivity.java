package com.project.discoverskool.Classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.project.discoverskool.Adapters.MyAdapter;
import com.project.discoverskool.Database.DBmain;
import com.project.discoverskool.Auth.LogInActivity;
import com.project.discoverskool.Model;
import com.project.discoverskool.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button,logout,categories;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    MyAdapter myAdapter;
    ArrayList<Model>modelArrayList;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        modelArrayList = new ArrayList<>();
        dBmain = new DBmain(this);
        recyclerView=findViewById(R.id.recyclerView1);
        myAdapter = new MyAdapter(HomeActivity.this, modelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        categories = findViewById(R.id.Cat_btn);
        categories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button =findViewById(R.id.button_add);
        logout = findViewById(R.id.button_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Cursor cursor = new DBmain(this).readalldata();
        while (cursor.moveToNext()){
            Model model = new Model(cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));
            modelArrayList.add(model);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddSchool.class);
                startActivity(intent);
                finish();
            }
        });
    }
}