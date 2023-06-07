package com.itp.spftest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_mail,et_pass;
    Button btn_login,btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mail=findViewById(R.id.et_mail);
        et_pass=findViewById(R.id.et_pass);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences spf=   getSharedPreferences("mySPF", Context.MODE_PRIVATE);

                String email=et_mail.getText().toString();
                String pass=et_pass.getText().toString();

                if(email.length()>0&&pass.length()>0)
                {
                  String uname=spf.getString("email",email);
                  String pas=spf.getString("pass",pass);
                   if(email.equals(uname)&&pass.equals(pas))
                   {
                       Toast.makeText(MainActivity.this, "Welcome: "+email, Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                   }else {
                       Toast.makeText(MainActivity.this, "invalid user!! plz try again", Toast.LENGTH_SHORT).show();
                   }

                }else {
                    Toast.makeText(MainActivity.this, "please enter username & password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}