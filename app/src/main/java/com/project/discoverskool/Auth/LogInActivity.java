package com.project.discoverskool.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.discoverskool.Classes.HomeActivity;
import com.project.discoverskool.Database.DBHelper;
import com.project.discoverskool.R;

public class LogInActivity extends AppCompatActivity {
    Button signup,login;
    EditText username, password;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = findViewById(R.id.user_txt1);
        password = findViewById(R.id.pass_txt1);
        login = findViewById(R.id.btn_login1);
        signup = findViewById(R.id.btn_SignUp1);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(LogInActivity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(user,pass);
                    if (checkUserPass==true){
                        Toast.makeText(LogInActivity.this,"Sign in successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LogInActivity.this,"wrong username or password",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogInActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });
    }
}