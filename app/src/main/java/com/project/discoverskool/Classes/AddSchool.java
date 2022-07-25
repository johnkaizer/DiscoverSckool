package com.project.discoverskool.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;
import com.project.discoverskool.Database.DBmain;
import com.project.discoverskool.R;

public class AddSchool extends AppCompatActivity {
    private Button uploadBtn;
    TextInputEditText school_name, sch_location, sch_status, sch_population, sch_description,sch_about;
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_school);

        school_name = findViewById(R.id.title_school);
        sch_location = findViewById(R.id.location_school);
        sch_status = findViewById(R.id.status_school);
        sch_population = findViewById(R.id.school_population);
        sch_description = findViewById(R.id.description_school);
        sch_about = findViewById(R.id.about_school);
        uploadBtn = findViewById(R.id.upload_button);
        dBmain=new DBmain(this);

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();

            }
        });
    }

    private void insertData() {
        sqLiteDatabase = dBmain.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put("name",school_name.getText().toString());
        cv.put("location",sch_location.getText().toString());
        cv.put("status",sch_status.getText().toString());
        cv.put("vacancy",sch_population.getText().toString());
        cv.put("description",sch_description.getText().toString());
        cv.put("about",sch_about.getText().toString());

        Long recid = sqLiteDatabase.insert("popularSch",null,cv);
        if(recid!=null){
            Toast.makeText(AddSchool.this,"successfully uploaded school",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddSchool.this, HomeActivity.class);
            startActivity(intent);
            clearData();
            finish();
        }else {
            Toast.makeText(AddSchool.this,"something went wrong try again",Toast.LENGTH_SHORT).show();

        }

    }

    private void clearData() {
        sch_description.setText("");
        sch_location.setText("");
        school_name.setText("");
        sch_status.setText("");
        sch_population.setText("");
        sch_about.setText("");
    }
}