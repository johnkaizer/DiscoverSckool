package com.project.discoverskool.Classes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.discoverskool.Auth.LogInActivity;
import com.project.discoverskool.R;

public class ItemDetails extends AppCompatActivity {
    TextView name,status,location,description,vacancy;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        name = findViewById(R.id.txt_title);
        location= findViewById(R.id.progress_txt);
        description= findViewById(R.id.textView10);
        vacancy = findViewById(R.id.Category_txt);
        status = findViewById(R.id.Amount_txt);
        button= findViewById(R.id.button_logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ItemDetails.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });


        name.setText(getIntent().getExtras().getString("name"));
        location.setText(getIntent().getExtras().getString("location"));
        description.setText(getIntent().getExtras().getString("description"));
        vacancy.setText(getIntent().getExtras().getString("vacancy"));
        status.setText(getIntent().getExtras().getString("status"));
    }
}