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

public class SignInActivity extends AppCompatActivity  {
    Button login1, signup1;
    EditText username, password,re_password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = findViewById(R.id.user_txt);
        password = findViewById(R.id.pass_txt);
        re_password = findViewById(R.id.re_pass_txt);
        login1 = findViewById(R.id.btn_login1);
        signup1 = findViewById(R.id.btn_SignUp1);
        DB = new DBHelper(this);
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass= password.getText().toString();
                String repass= re_password.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass))
                    Toast.makeText(SignInActivity.this,"All field are required",Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        Boolean checkUser= DB.checkUsername(user);
                        if (checkUser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(SignInActivity.this,"Registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(SignInActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();

                            }else{
                                Toast.makeText(SignInActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignInActivity.this,"You already have an account",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignInActivity.this,"passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}